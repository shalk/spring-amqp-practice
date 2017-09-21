package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut4;

import java.util.Random;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {

	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private DirectExchange  exchange;
	
	private Random random = new Random(42);
	@Scheduled(initialDelay=100, fixedDelay=500)
	void send(){
		int code = random.nextInt(44);
		String[] routekeys = new String[]{"orange", "apple", "pen"};
		String routekey = routekeys[code % 3];
		String msg = "Hello world !" + code + " " + routekey ;
		this.template.convertAndSend(exchange.getName(), routekey, msg);
		System.out.println("[x] exchange " + exchange.getName() + " send:" + msg);
	}
}
