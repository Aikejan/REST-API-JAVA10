package peaksoft.models;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDate;

public class AuthorListeners {
    @PrePersist
    public void save(Author author) {
        author.setCreatedAt(LocalDate.now());  // TEKUSHIE VREMYA POKAZYVAET
        author.setUpdatedAt(LocalDate.now());  // OBNOVIT VREMYA
    }

    @PreUpdate
    public void update(Author author) {
        author.setUpdatedAt(LocalDate.now());
    }
}
