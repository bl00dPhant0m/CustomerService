package org.spring.customerservice.exeption;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<String> phoneNotPresentException(PropertyValueException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();

        String collect = Arrays.stream(stackTrace).map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));

        log.error(e.getMessage());
        log.error(collect);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    //обработка исклюения если добавляется юзер без телеона
    //дописать удаление клинета по id(url)
    //редактирования (принять id(URL) и castomer(body) )
    //получения всех клиантов - вернуть лист
    //создать в постмане коллекцию экспортировать ее в проект доблавить Readme.md залить на гитхаб и скинуть ссылку на проект

}