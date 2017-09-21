package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Recv {

	@RabbitListener(queues="#{queue1.name}")
	int fabi(int n) {
		System.out.println("[x] server get:" + n);
		int res = fab(n);
		System.out.println("[x] reply:" + res);
		return res;
	}
	
	int fab(int n) {
		if( n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return fab(n - 2) + fab(n - 1);

	}
}
