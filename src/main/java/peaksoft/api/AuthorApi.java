package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Author;
import peaksoft.services.AuthotService;


import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Controller
@RequiredArgsConstructor
public class AuthorApi {
    private final AuthotService authotService;

    @GetMapping
    public List<Author> findAll() {
        return authotService.findAll();
    }


    @PostMapping
    public String save(@RequestBody Author newAuthor) {
        return authotService.save(newAuthor);
    }


    @PutMapping("/{id}")
    public String update(@RequestBody Author newAuthor, @PathVariable Long id) {
        return authotService.update(id, newAuthor);


    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return authotService.deleteById(id);

    }
}
