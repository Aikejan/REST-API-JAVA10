package peaksoft.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Book;
import peaksoft.models.Sort;
import peaksoft.services.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookApi {
    private final BookService bookService;


    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{authorId}")
    public List<Book> findAllByAuthorId(@PathVariable Long authorId) {
        return bookService.findAllByAuthorId(authorId);
    }


    @PostMapping
    public String save(@PathVariable Long authorId, @RequestBody Book newBook) {
        return bookService.save(authorId, newBook);

    }

    @GetMapping
    public List<Book> findAllBookOrderBy(@RequestParam String orderBy) {
        return bookService.findAll(orderBy);

    }
}
