package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile({"tut2","worker-queue"})
@Configuration
public class TuT2Config {

	@Bean
	public Queue queue() {
		return new Queue("hello2");
	}

	@Profile("sender")
	@Bean
	public Sender sender() {
		return new Sender();
	}

	@Profile("recv")
	public static class RecvConfig {
		@Bean
		public Recv Recv1() {
			return new Recv(1);
		}

		@Bean
		public Recv Recv2() {
			return new Recv(2);
		}
	}
}
