package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Author;
import peaksoft.repositories.AuthorRepository;
import peaksoft.services.AuthotService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthotService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public String save(Author newAuthor) {
        authorRepository.save(newAuthor);
        return "Successfully saved. Book info:" + newAuthor;
    }

    @Override
    @Transactional
    public String update(Long id, Author newAuthor) {
        Author currentAuthor = findById(id);
        currentAuthor.setFullName(newAuthor.getFullName());
        return "Successfully updated";
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Author with id: " + id + "Not found"));
    }

    @Override
    public String deleteById(Long id) {

        authorRepository.deleteById(findById(id).getId());
        return "Successfully deleted";

    }
}
