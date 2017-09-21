package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {

	@Autowired
	RabbitTemplate rt;

	@Autowired
	TopicExchange topic;

	@Scheduled(initialDelay = 100, fixedDelay = 500)
	public void send1() {
		// try lazy.orange lazy.rabbit  nice.orange.rabbit 
		String routingKey = "lazy.orange.nice";
		String msg = "routingKey=" + routingKey + " id:" + 1;
		rt.convertAndSend(topic.getName(), routingKey, msg);
		System.out.println("[x] send:" + msg + "to:" + routingKey);
	}
}
