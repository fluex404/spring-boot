package com.fluex404.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/helloworld")
public class HelloWorld {
    @GetMapping
    public ResponseEntity<?> getHelloWorld() throws Exception {
        ModelMap m = new ModelMap();

        m.put("name", "Isa Subani");
        m.put("email", "isaabqari@gmail.com");
        m.put("phone", "123123");

        return new ResponseEntity<>(m, HttpStatus.OK);
    }
}
