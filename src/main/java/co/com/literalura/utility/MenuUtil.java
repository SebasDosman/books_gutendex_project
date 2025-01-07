package co.com.literalura.utility;

import co.com.literalura.model.Author;
import co.com.literalura.model.Book;

import java.util.List;
import java.util.Scanner;

public class MenuUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showWelcomeMessage() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.WELCOME_MESSAGE);
    }

    public static int showMenuOptions() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.MENU_OPTIONS);
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.MENU_OPTION_MESSAGE);

        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    public static String showSearchBookByTitleMessage() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.SEARCH_BOOK_BY_TITLE_MESSAGE);

        return scanner.nextLine();
    }

    public static String showSearchBookByLanguageMessage() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.SEARCH_BOOK_BY_LANGUAGE_MESSAGE);

        return scanner.nextLine();
    }

    public static int showSearchAuthorsAliveInYearMessage() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.SEARCH_AUTHORS_ALIVE_IN_YEAR_MESSAGE);

        return scanner.nextInt();
    }

    public static void showGoodbyeMessage() {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.GOODBYE_MESSAGE);
    }

    public static void showBookByTitleMessage(Book book) {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);
        System.out.println(ConstantsUtil.BOOK_BY_TITLE_MESSAGE.concat(book.getTitle()));
    }

    public static void showAllBooksMessage(List<Book> books) {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);

        books.forEach(book -> System.out.println(book.getTitle()));
    }

    public static void showAllAuthorsMessage(List<Author> authors) {
        System.out.println(ConstantsUtil.MENU_SEPARATOR);

        authors.forEach(author -> System.out.println(author.getName()));
    }
}
