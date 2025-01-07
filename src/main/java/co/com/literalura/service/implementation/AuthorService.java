package co.com.literalura.service.implementation;

import co.com.literalura.model.Author;
import co.com.literalura.repository.AuthorRepository;
import co.com.literalura.service.IAuthorService;
import co.com.literalura.utility.MenuUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findAuthorsAliveInYear() {
        int year = MenuUtil.showSearchAuthorsAliveInYearMessage();

        return authorRepository.findAuthorsAliveInYear(year);
    }
}
