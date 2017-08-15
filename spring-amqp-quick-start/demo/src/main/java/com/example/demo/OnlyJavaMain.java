package com.example.demo;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class OnlyJavaMain {
	public static void main(final String... args) throws Exception {

		ConnectionFactory cf = new CachingConnectionFactory("10.0.33.144");
//		ConnectionFactory connectionFactory = new CachingConnectionFactory();
		AmqpAdmin admin = new RabbitAdmin(cf);
		admin.declareQueue(new Queue("myqueue"));
		AmqpTemplate template = new RabbitTemplate(cf);
		String msg = "foo";
//		template.convertAndSend("myqueue", msg);
//		System.out.println("[x] send:" + msg);
		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println("[x] recv:" + foo);
	}
}
