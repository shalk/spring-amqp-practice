package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut6;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("tut6")
@Configuration
public class TuT6Config {

	@Bean
	public Queue queue1() {
		return new Queue("tut6-queue");
	}

	@Profile("sender")
	public static class SenderConfig {
		@Bean
		public Sender send() {
			return new Sender();
		}

	}

	@Profile("recv")
	public static class RecvConfig {

		@Bean
		public Recv recv() {
			return new Recv();
		}
	}

}
