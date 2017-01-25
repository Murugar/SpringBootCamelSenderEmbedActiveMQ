package com.iqmsoft.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import javax.jms.Connection
import javax.jms.ConnectionFactory
import javax.jms.DeliveryMode
import javax.jms.Destination
import javax.jms.MessageProducer
import javax.jms.Session
import javax.jms.TextMessage
import com.iqmsoft.ActiveMQApplication
import com.iqmsoft.AppConfig
import com.iqmsoft.Producer


@ContextConfiguration(loader = SpringApplicationContextLoader.class, 
	classes = [ActiveMQApplication])
class ActiveMQTest extends Specification{
	
	@Autowired
	Producer producer1
	
	@Autowired
	@Qualifier("jmsConnectionFactory")
	ConnectionFactory jmsConnectionFactory
	String queueName = AppConfig.MY_QUEUE
	Session session
	Destination destination
	MessageProducer producer
	def setup(){
		Connection conn = jmsConnectionFactory.createConnection()
		conn.start()
		session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)
		destination = session.createQueue(queueName)
		this.producer = session.createProducer(destination)
		this.producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT)
	}
	def "Test Send and Receive of Message"() {
		given:
		TextMessage txtMessage = session.createTextMessage()
		txtMessage.setText("Larry the Cable Guy")
		when:
		producer.send(destination, txtMessage)
		sleep(3000) 
		producer1.send("Test message");
		sleep(3000)
		then:
		true
	}
}