package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut5;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * tut5 介绍topic类型的exchange
 * 一个发送者 两个队列收， 设置3个不同的bindding；
 * @author shalk
 *
 */
@Profile("tut5")
@Configuration
public class TuT5Config {
	
	@Bean
	public TopicExchange topic(){
		return new TopicExchange("tut5", false, false, null);
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
		public Queue queue1() {
			return new AnonymousQueue();
		}

		@Bean
		public Queue queue2() {
			return new AnonymousQueue();
		}
		
		@Bean
		public Binding bind1(Queue queue1, TopicExchange topic) {
			return BindingBuilder.bind(queue1).to(topic).with("*.orange.*");
		}
		
		@Bean
		public Binding bind2(Queue queue2, TopicExchange topic) {
			return BindingBuilder.bind(queue2).to(topic).with("*.*.rabbit");
		}

		@Bean
		public Binding bind3(Queue queue2, TopicExchange topic) {
			return BindingBuilder.bind(queue2).to(topic).with("lazy.#");
		}

		@Bean
		public Recv recv() {
			return new Recv();
		}
		
	}
}
