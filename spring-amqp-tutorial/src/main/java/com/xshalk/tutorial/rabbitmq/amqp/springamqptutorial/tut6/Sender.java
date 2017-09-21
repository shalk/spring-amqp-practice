package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut6;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {
	
	@Autowired
	RabbitTemplate rt;
	
	private int num = 0;
	
	@Scheduled(initialDelay=5000, fixedDelay=1000)
	public void send() {
		String queueName = "tut6-queue";
		String routingKey = queueName;
		Integer result = (Integer)rt.convertSendAndReceive(routingKey, num % 10);
		System.out.println("[x] send:" + num % 10);
		num++;
		System.out.println("[x] get:" + result);
	}

}
