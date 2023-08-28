package peaksoft.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Author;
import peaksoft.models.Book;
import peaksoft.models.Sort;
import peaksoft.repositories.AuthorRepository;
import peaksoft.repositories.BookRepository;
import peaksoft.services.BookService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;
    private  final AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @Override
    public String save(Long authorId, Book newBook) {
      Author author = authorRepository.findById(authorId).orElseThrow(()->
                new NoSuchElementException("Author with id: " +authorId+"Not found"));
      author.getBooks().add(newBook);
      newBook.setAuthor(author);
      bookRepository.save(newBook);
        return "Successfully saved book";
    }

    @Override
    public List<Book> findAllBookOrderBy(Sort sort) {
        return bookRepository.findAllBookOrderBY(sort);
    }

    @Override
    public List<Book> findAll(String name, String orderBy) {
        return null;
    }


    @Override
    public List<Book> findAll(String orderBy) {
        String uperCase = orderBy.toUpperCase();
        if(uperCase.equals("DESC"))

            return  bookRepository.testtest();
        else {return bookRepository.test();

    }
    }
}
