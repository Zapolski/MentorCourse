package by.itacademy.laboratory.week.sixth.controller;

import by.itacademy.laboratory.week.sixth.validator.BookFilterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerHelper {

    private final BookFilterValidator bookFilterValidator;

    @Autowired
    public ControllerHelper(BookFilterValidator bookFilterValidator) {
        this.bookFilterValidator = bookFilterValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(bookFilterValidator);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleError(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
    }
}
