package com.vrv.interview.web;

import com.vrv.interview.domain.Book;
import com.vrv.interview.exception.GeneralException;
import com.vrv.interview.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 图书资源接口
 *
 * @author YunJ
 */
@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        Optional<Book> book = bookService.lambdaQuery().eq(Book::getId, id).oneOpt();
        if (!book.isPresent()) {
            log.info("Book not found, id={}", id);
            throw new GeneralException("Book not found");
        }
        return ResponseEntity.ok(book.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeBook(@PathVariable Long id) {
        bookService.removeById(id);
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

    @PostMapping()
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.ok(book);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateById(book);
        return ResponseEntity.ok(book);
    }
}
