package co.com.literalura.service;

import co.com.literalura.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    List<Book> findByLanguage();
    Book findByTitle();
}
