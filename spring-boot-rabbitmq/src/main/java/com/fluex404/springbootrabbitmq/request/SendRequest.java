package com.fluex404.springbootrabbitmq.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendRequest {
    private String name;
    private String email;
}
