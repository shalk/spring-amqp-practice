package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut3;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({ "tut3", "pub-sub" })
@Configuration
public class TuT3Config {

	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("pubsub", false, false, null);
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
		public Binding binding1(FanoutExchange fanout, Queue queue1) {
			return BindingBuilder.bind(queue1).to(fanout);
		}

		@Bean
		public Binding binding2(FanoutExchange fanout, Queue queue2) {
			return BindingBuilder.bind(queue2).to(fanout);
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
