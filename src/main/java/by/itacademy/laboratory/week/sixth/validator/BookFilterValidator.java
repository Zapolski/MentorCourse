package by.itacademy.laboratory.week.sixth.validator;

import by.itacademy.laboratory.week.sixth.dto.BookFilter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

@Component
public class BookFilterValidator extends ValidatorBase<BookFilter> {

    @Override
    public void validateObject(BookFilter object, Errors errors) {
        if (isAllFieldsNull(object.getAuthors(), object.getGenres(), object.getFromYear(), object.getToYear())) {
            errors.reject("100", "Filter parameters are empty");
        } else if (nonNull(object.getFromYear()) && nonNull(object.getToYear()) && object.getFromYear() > object.getToYear()) {
            errors.reject("101", "Year from should be before year to");
        }
    }

    private boolean isAllFieldsNull(Object... objects) {
        return Stream.of(objects)
                .allMatch(Objects::isNull);
    }
}
