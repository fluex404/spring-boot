package com.fluex404.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.Date;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception) {

        ModelMap m = new ModelMap();
        m.put("data", null);
        m.put("message", exception.getMessage());
        m.put("date", new Date());

        return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
    }
 }
