package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}