package peaksoft.services;

import peaksoft.models.Book;
import peaksoft.models.Sort;


import java.util.List;

public interface BookService {
    List<Book> findAll();

    List<Book> findAllByAuthorId(Long authorId);

    String save(Long authorId, Book newBook);


    List<Book> findAllBookOrderBy(Sort sort);


    List<Book> findAll(String name, String orderBy);

    List<Book> findAll(String orderBy);
}
