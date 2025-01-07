package co.com.literalura.repository;

import co.com.literalura.model.Book;
import co.com.literalura.model.LanguageCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN b.languages l WHERE l.languageCode = :languageCode")
    List<Book> findByLanguage(@Param("languageCode") LanguageCode languageCode);
}
