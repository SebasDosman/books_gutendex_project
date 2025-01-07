package co.com.literalura.service;

import co.com.literalura.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    List<Author> findAuthorsAliveInYear();
}
