package com.iqmsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        send("Message");
        System.out.println("Messages were sent to the Queues");
    }

    public void send(String msg) {
//          Send a message
//        creating messages with MessageCreator
//        MessageCreator messageCreator = session -> session.createTextMessage("ping!");
//        jmsTemplate.send(this.queue, messageCreator);
        System.out.println("Sending a new message.");
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
        this.jmsMessagingTemplate.convertAndSend("myqueue", msg + "AAA");
    }

}
