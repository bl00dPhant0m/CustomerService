package org.spring.customerservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PhoneNotPresentException.class)
    public ResponseEntity<String> phoneNotPresentException(PhoneNotPresentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //обработка исклюения если добавляется юзер без телеона
    //дописать удаление клинета по id(url)
    //редактирования (принять id(URL) и castomer(body) )
    //получения всех клиантов - вернуть лист
    //создать в постмане коллекцию экспортировать ее в проект доблавить Readme.md залить на гитхаб и скинуть ссылку на проект

}