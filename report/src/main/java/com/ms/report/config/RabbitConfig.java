package com.ms.report.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitConfig {

	@Value("${broker.queue.logs.name}")
	private String queue;

	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}

	@Bean
	public Exchange logExchange() {
		return new DirectExchange("logExchange");
	}

	@Bean 
	public Binding binding(Queue logQueue, Exchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange).with(queue).noargs();
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objMapper = new ObjectMapper();

		return new Jackson2JsonMessageConverter(objMapper);
	}
}
