package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.models.Book;
import peaksoft.models.Sort;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.author.id= :authorId")
    List<Book> findByAuthorId(Long authorId);

    @Query("select  b from  Book order by :sort")
    List<Book> findAllBookOrderBY(Sort sort);

    @Query("select b from  Book  b order by b.fullName asc")
    List<Book> findAllBooksASC();

    @Query("select  b from  Book b order by  b.fullName desc")
    List<Book> fundAllDESC();

    @Query("select b from  Book  b order by b.fullName asc")
    List<Book> test();

    @Query("select b from  Book  b order by b.fullName desc")
    List<Book> testtest();
}