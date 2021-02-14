package com.fluex404.springbootrabbitmq.services;

import com.fluex404.springbootrabbitmq.amqp.Publisher;
import com.fluex404.springbootrabbitmq.request.SendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendServices {

    @Autowired
    private Publisher publisher;

    public void send(SendRequest sendRequest) throws Exception {
        Map<String, String> m = new HashMap<>();;

        m.put("nama", sendRequest.getName());
        m.put("email", sendRequest.getEmail());

        publisher.produceMsg(m);
    }
}
