package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuthorListeners.class)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name = "author_seq",
            allocationSize = 1)

    private Long id;
    private String fullName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books = new ArrayList<>();
    private LocalDate createdAt;
    private LocalDate updatedAt;


}