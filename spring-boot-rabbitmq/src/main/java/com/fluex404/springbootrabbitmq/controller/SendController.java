package com.fluex404.springbootrabbitmq.controller;

import com.fluex404.springbootrabbitmq.request.SendRequest;
import com.fluex404.springbootrabbitmq.services.SendServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
public class SendController {

    @Autowired
    private SendServices sendService;

    @PostMapping
    public ResponseEntity send(@RequestBody SendRequest sendRequest) throws Exception{

        sendService.send(sendRequest);

        return ResponseEntity.ok(sendRequest);
    }
}
