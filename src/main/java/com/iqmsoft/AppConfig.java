package com.iqmsoft;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
//@EnableJms
public class AppConfig {

	   public static final String MY_QUEUE = "myqueue";
	
	 
	   @Bean
	    public Queue queue() {
	        return new ActiveMQQueue(MY_QUEUE);
	    }
	
}
