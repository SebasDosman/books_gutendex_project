package co.com.literalura.repository;

import co.com.literalura.model.Language;
import co.com.literalura.model.LanguageCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Optional<Language> findByLanguageCode(LanguageCode languageCode);
}
