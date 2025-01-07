package co.com.literalura.view;

import co.com.literalura.service.IAuthorService;
import co.com.literalura.service.IBookService;
import co.com.literalura.utility.ConstantsUtil;
import co.com.literalura.utility.MenuUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuHandler {
    private final IBookService bookService;
    private final IAuthorService authorService;

    public void start() {
        MenuUtil.showWelcomeMessage();

        while (true) {
            int option = MenuUtil.showMenuOptions();
            if (option == 0) {
                MenuUtil.showGoodbyeMessage();
                break;
            }

            try {
                switch (option) {
                    case 1:
                        MenuUtil.showBookByTitleMessage(bookService.findByTitle());
                        break;
                    case 2:
                        MenuUtil.showAllBooksMessage(bookService.findAll());
                        break;
                    case 3:
                        MenuUtil.showAllAuthorsMessage(authorService.findAll());
                        break;
                    case 4:
                        MenuUtil.showAllAuthorsMessage(authorService.findAuthorsAliveInYear());
                        break;
                    case 5:
                        MenuUtil.showAllBooksMessage(bookService.findByLanguage());
                        break;
                    default:
                        System.out.println(ConstantsUtil.INVALID_OPTION_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(ConstantsUtil.ERROR_MESSAGE.concat(e.getMessage()));
            }
        }
    }
}
