package com.iqmsoft;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class Routes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:myqueue").bean(Processing.class, "doSomething").to("jms:redirected");
        from("jms:testing").bean(Processing.class, "doSomething").to("jms:redirected");
    }
}