package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq",
            allocationSize = 1)

    private Long id;
    private String fullName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;
    @Transient
    private String ascORDesc;

}