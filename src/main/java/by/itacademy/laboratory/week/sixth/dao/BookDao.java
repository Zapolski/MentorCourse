package by.itacademy.laboratory.week.sixth.dao;

import by.itacademy.laboratory.week.sixth.dto.BookDto;
import by.itacademy.laboratory.week.sixth.dto.BookFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class BookDao {

    private static final String GET_BOOKS_BY_FILTER_PARAMETERS =
            "SELECT a.name AS author_name, g.name AS genre_name, " +
                    "b.name AS book_name, b.creation_year FROM book_storage.book b " +
                    "INNER JOIN book_storage.genre g ON b.genre_id = g.id " +
                    "INNER JOIN book_storage.author a ON b.author_id = a.id " +
                    "WHERE (:authors_filter OR a.name IN (:authors)) " +
                    "AND (:genres_filter OR g.name IN (:genres)) " +
                    "AND (cast(:fromYear as text) IS NULL OR b.creation_year >= :fromYear) " +
                    "AND (cast(:toYear as text) IS NULL OR b.creation_year <= :toYear) ";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookDto> getBooks(BookFilter bookFilter) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("authors", bookFilter.getAuthors());
        parameters.addValue("authors_filter", bookFilter.getAuthors() == null);
        parameters.addValue("genres", bookFilter.getGenres());
        parameters.addValue("genres_filter", bookFilter.getGenres() == null);
        parameters.addValue("fromYear", bookFilter.getFromYear());
        parameters.addValue("toYear", bookFilter.getToYear());

        return jdbcTemplate.query(GET_BOOKS_BY_FILTER_PARAMETERS, parameters, (ResultSet resultSet, int index) ->
                BookDto.builder()
                        .authorName(resultSet.getString("author_name"))
                        .genreName(resultSet.getString("genre_name"))
                        .bookName(resultSet.getString("book_name"))
                        .creationYear(resultSet.getInt("creation_year"))
                        .build());
    }
}
