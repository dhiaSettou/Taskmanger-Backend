package com.training.training.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.hibernate.exception.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerMsg {

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public final ResponseEntity<List<String>> handleHeaderException()
    {
        return new ResponseEntity("Media Type Not Supported: Must be Json", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {

            String errorMessage = error.getDefaultMessage();

            errors.add(errorMessage);
        }
        return new ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> handleNullRequestBodyExceptions() {
        return new ResponseEntity("Body must not be null", HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException e){
        return  new ResponseEntity<Object>(String.format("%s",e.getMessage()),HttpStatus.UNAUTHORIZED);
    }
    //TODO Discuss how to handle this error on the client side
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var message= mapper.writeValueAsString(e.getCause().getMessage());
        return  new ResponseEntity<Object>(message,HttpStatus.CONFLICT);
    }

}