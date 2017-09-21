package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {

	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private FanoutExchange  exchange;
	
	@Scheduled(initialDelay=100, fixedDelay=500)
	void send(){
		String msg = "Hello world 3!";
		this.template.convertAndSend(exchange.getName(), "", msg);
		System.out.println("[x] exchange " + exchange.getName() + " send:" + msg);

	}
}
