package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut4;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Recv {
	
	@RabbitListener(queues = "#{queue1.name}")
	public void receive1(String in) throws InterruptedException {
		receive(in, "orange");
	}

	@RabbitListener(queues = "#{queue2.name}")
	public void receive2(String in) throws InterruptedException {
		receive(in, "apple pen");
	}

	public void receive(String in, String receiver) throws InterruptedException {
		System.out.println("instance " + receiver + " [x] Received '" + in + "'");
	}

	
}
