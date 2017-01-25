package com.iqmsoft;

import org.springframework.stereotype.Component;


@Component
public class Processing {
    public String doSomething(String body) {
        System.out.println("Processing");
        System.out.println(body);
        return transform(body).toUpperCase();
    }
    
    private String transform(String body) {
        System.out.println("Transforming");
        System.out.println("yyyy " + body);
        String p = "yyyy " + body;
        return p.toUpperCase();
    }
    
}
