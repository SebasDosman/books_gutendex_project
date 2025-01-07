package co.com.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
         @JsonAlias("title") String title,
         @JsonAlias("authors") List<AuthorData> authors,
         @JsonAlias("subjects") List<String> subjects,
         @JsonAlias("bookshelves") List<String> bookshelves,
         @JsonAlias("languageCodes") List<String> languages,
         @JsonAlias("copyright") Boolean copyright,
         @JsonAlias("media_type") String mediaType,
         @JsonAlias("download_count") Integer downloadCount
) { }
