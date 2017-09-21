package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues="hello2")
public class Recv {

	private String name;
	public Recv(int i) {
		// Todo aa
		this.name = "receiver " + i;
	}

	@RabbitHandler
	void rec(String in){
		System.out.println(" [x] " + this.name + " Received '" + in + "'");
	}
}
