package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {
	
	@Autowired
	Queue queue;
	
	@Autowired
	RabbitTemplate template;
	
	private int i = 0;
	@Scheduled(fixedDelay = 500, initialDelay = 100)
	public void send() {
		
		String msg = "Hello world, tut2! No." + i++;
		this.template.convertAndSend(queue.getName(), msg);
		System.out.println("[x] send:" + msg);
	}
}
