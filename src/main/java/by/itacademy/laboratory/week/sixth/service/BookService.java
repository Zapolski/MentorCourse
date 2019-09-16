package by.itacademy.laboratory.week.sixth.service;

import by.itacademy.laboratory.week.sixth.dao.BookDao;
import by.itacademy.laboratory.week.sixth.dto.BookFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<String> getCsvRows(BookFilter bookFilter) {
        return bookDao.getBooks(bookFilter).stream()
                .map(it -> String.format("%s, %s, %s, %s", it.getBookName(), it.getCreationYear(), it.getGenreName(), it.getAuthorName()))
                .collect(Collectors.toList());
    }
}
