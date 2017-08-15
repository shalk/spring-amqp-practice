package com.xshalk.tutorial.rabbitmq.amqp.springamqptutorial.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
@Configuration
public class Tut1Config {
	
	
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    
    @Profile("sender")
    @Bean
    public Sender sender(){
    	return new Sender();
    }
    
    @Profile("receiver")
    @Bean
    public Receiver receiver(){
    	return new Receiver();
    }

}
