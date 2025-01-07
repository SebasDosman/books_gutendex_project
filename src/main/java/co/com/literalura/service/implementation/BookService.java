package co.com.literalura.service.implementation;

import co.com.literalura.model.*;
import co.com.literalura.repository.AuthorRepository;
import co.com.literalura.repository.BookRepository;
import co.com.literalura.repository.LanguageRepository;
import co.com.literalura.service.IApiConsumptionService;
import co.com.literalura.service.IBookService;
import co.com.literalura.service.IConvertData;
import co.com.literalura.utility.ConstantsUtil;
import co.com.literalura.utility.MenuUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;
    private final IApiConsumptionService apiConsumptionService;
    private final IConvertData convertData;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByLanguage() {
        String language = MenuUtil.showSearchBookByLanguageMessage();

        return bookRepository.findByLanguage(LanguageCode.fromString(language));
    }

    @Override
    public Book findByTitle() {
        Results results = getResults();

        List<Author> authors = results.results().getFirst().authors().stream().map(this::getOrCreateAuthor).collect(Collectors.toList());
        List<Language> languages = results.results().getFirst().languages().stream().map(this::getOrCreateLanguage).collect(Collectors.toList());

        Book book = convertToBook(results.results().getFirst(), authors, languages);
        return bookRepository.save(book);
    }

    private Results getResults() {
        String title = MenuUtil.showSearchBookByTitleMessage();

        String url = ConstantsUtil.BASE_URL.concat("?search=").concat(title.toLowerCase().replace(" ", "%20"));
        String response = apiConsumptionService.getApiData(url);
        Results results = convertData.getApiData(response, Results.class);

        if (results == null || results.results().isEmpty()) {
            throw new RuntimeException(ConstantsUtil.NO_BOOKS_FOUND_MESSAGE.concat(title));
        }

        return results;
    }

    private Author getOrCreateAuthor(AuthorData authorData) {
        return authorRepository.findByName(authorData.name()).orElseGet(() -> authorRepository.save(convertToAuthor(authorData)));
    }

    private Language getOrCreateLanguage(String languageCode) {
        return languageRepository.findByLanguageCode(LanguageCode.fromString(languageCode)).orElseGet(() -> languageRepository.save(convertToLanguage(languageCode)));
    }

    private Author convertToAuthor(AuthorData authorData) {
        return Author.builder()
                .name(authorData.name())
                .birthYear(authorData.birthYear())
                .deathYear(authorData.deathYear())
                .build();
    }

    private Language convertToLanguage(String languageCode) {
        return Language.builder()
                .languageCode(LanguageCode.fromString(languageCode))
                .build();
    }

    private Book convertToBook(BookData bookData, List<Author> authors, List<Language> languages) {
        return Book.builder()
                .title(bookData.title())
                .authors(authors)
                .languages(languages)
                .build();
    }
}
