package com.microsservice.user.configs;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

	@Value("${broker.queue.email.name}")
	private String queue;

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objMapper = new ObjectMapper();

		return new Jackson2JsonMessageConverter(objMapper);
	}
}
