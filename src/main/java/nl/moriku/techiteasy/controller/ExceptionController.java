package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    //    Deze exception handler vangt elke RecordNotFoundException op die naar de gebruiker gegooid wordt en returned daar voor in de plaats een ResponseEntity met de Message en de NOT_FOUND-status (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> exception(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

//    //    Bonus exception handler
//    @ExceptionHandler(value = IndexOutOfBoundsException.class)
//    public ResponseEntity<Object> exception(IndexOutOfBoundsException exception) {
//
//        return new ResponseEntity<>("Dit id staat niet in de database", HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(value = TelevisionNameTooLongException.class)
//    public ResponseEntity<String> exception(TelevisionNameTooLongException exception) {
//
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
