package com.fluex404.springbootrabbitmq.amqp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


@Component
public class Subcriber {



    @RabbitListener(queues = "${myQueue}")
    public void receivedMessage(
            Message msg
    ) throws Throwable
    {


        ObjectMapper mapper = new ObjectMapper();

        // convert JSON string to Map
        HashMap<String, String> params = mapper.readValue(msg.getBody(), new TypeReference<HashMap<String, String>>() {});
        System.out.println("you got message: "+params);



        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=preparer.xml");

    }
}