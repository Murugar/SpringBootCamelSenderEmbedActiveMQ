package com.iqmsoft;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private int counter = 0;

    @JmsListener(destination = "myqueue")
    public void receiveQueue(String text) {
        System.out.printf("Receiving %d: %s\n", counter++, text);
    }

    @JmsListener(destination = "testing")
    public void receiveTestingQueue(String text) {
        System.out.printf("Receiving new queue %d: %s\n", counter++, text);
    }

    @JmsListener(destination = "redirected")
    public void receiveRedirectedQueue(String text) {
        System.out.printf("Receiving redirected queue %d: %s\n", counter++, text);
    }

}
