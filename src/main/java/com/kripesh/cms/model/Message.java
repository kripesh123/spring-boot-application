package com.kripesh.cms.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {

    @Value("${app.greeting}")
    private String message;

    public String getMessage() {
        return message;
    }

}
