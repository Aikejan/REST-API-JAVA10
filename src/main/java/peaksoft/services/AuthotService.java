package peaksoft.services;

import peaksoft.models.Author;

import java.util.List;

public interface AuthotService {
    List<Author> findAll();

    String save(Author newAuthor);

    String update(Long id, Author newAuthor);

    Author findById(Long id);

    String deleteById(Long id);
}
