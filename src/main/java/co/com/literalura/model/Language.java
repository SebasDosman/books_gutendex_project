package co.com.literalura.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Entity
@NoArgsConstructor
@Setter
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageCode languageCode;
    @ManyToMany(mappedBy = "languages")
    private List<Book> books;
}
