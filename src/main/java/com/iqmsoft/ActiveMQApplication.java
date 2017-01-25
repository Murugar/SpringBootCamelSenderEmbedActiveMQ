package com.iqmsoft;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class ActiveMQApplication {
   // @Value("${spring.activemq.broker-url}")
  //  private String brokerUrl;

   /* @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;
*/
    
    

   // @Bean
 //   public Queue queue() {
        //return new ActiveMQQueue("myqueue");
   // }

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(ActiveMQApplication.class, args);
        
        BrokerService broker = new BrokerService();
        broker.setUseJmx(false);
        broker.setPersistent(false);
        broker.setUseShutdownHook(false);
        broker.addConnector("tcp://localhost:6060");
      
        broker.start();
  
       
    }

}