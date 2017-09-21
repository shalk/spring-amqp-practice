package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut4;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({ "tut4", "route" })
@Configuration
public class TuT4Config {

	@Bean
	public DirectExchange direct() {
		return new DirectExchange("tut4", false, false, null);
	}

	@Profile("recv")
	public static class RecvConfig {
		
		@Bean
		public Queue queue1() {
			return new AnonymousQueue();
		}

		@Bean
		public Queue queue2() {
			return new AnonymousQueue();
		}

		@Bean
		public Binding binding1(DirectExchange direct, Queue queue1) {
			return BindingBuilder.bind(queue1).to(direct).with("orange");
		}

		@Bean
		public Binding binding2(DirectExchange direct, Queue queue2) {
			return BindingBuilder.bind(queue2).to(direct).with("apple");
		}
		
		@Bean
		public Binding binding3(DirectExchange direct, Queue queue2) {
			return BindingBuilder.bind(queue2).to(direct).with("pen");
		}

		@Bean
		public Recv recv1() {
			System.out.println("new Recv");
			return new Recv();
		}

	}

	@Profile("sender")
	@Bean
	public Sender sender() {
		return new Sender();
	}


}
