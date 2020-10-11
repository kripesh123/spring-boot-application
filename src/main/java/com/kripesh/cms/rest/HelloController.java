package com.kripesh.cms.rest;


import com.kripesh.cms.CmsApplication;
import com.kripesh.cms.model.Person;
import com.kripesh.cms.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);


    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public Person index(@RequestParam(value = "name", defaultValue = "Everyone") String name) {
        return new Person(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/quote")
    public Quote getQuote(){
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",
                Quote.class);
        log.info(quote.toString());
        return quote;
    }
}
