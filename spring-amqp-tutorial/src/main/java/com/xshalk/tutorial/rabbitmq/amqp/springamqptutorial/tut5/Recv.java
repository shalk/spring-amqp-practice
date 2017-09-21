package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Recv {

	@RabbitListener(queues="#{queue1.name}")
	void recv1(String in){
		System.out.println("queue 1[*.orange.*] recv:" + in);
	}

	@RabbitListener(queues="#{queue2.name}")
	void recv2(String in){
		System.out.println("queue 2[lazy.#,*.*.rabbit] recv:" + in);
	}

}
