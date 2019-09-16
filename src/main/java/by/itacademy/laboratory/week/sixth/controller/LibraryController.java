package by.itacademy.laboratory.week.sixth.controller;

import by.itacademy.laboratory.week.sixth.dto.BookFilter;
import by.itacademy.laboratory.week.sixth.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> uploadFile(@Valid @RequestBody BookFilter bookFilter) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"books.csv\"")
                .body(bookService.getCsvRows(bookFilter).stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
