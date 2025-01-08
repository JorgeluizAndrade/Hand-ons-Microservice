package com.microsservice.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microsservice.user.dto.EmailDTO;
import com.microsservice.user.entity.User;

@Component
public class UserProducer {
	
	private final RabbitTemplate rabbitTemplate;

	public UserProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Value("${broker.queue.email.name}")
	private String routingKey;

	public void publishMessageEmail(User user) {
		var emailDto = new EmailDTO();

		emailDto.setUserId(user.getUserId());
		emailDto.setEmailTo(user.getEmail());
		emailDto.setSubject("Cadastro realizado com sucesso!");
		emailDto.setText(user.getName()
				+ ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa ");
		
		 rabbitTemplate.convertAndSend("", routingKey, emailDto);
	}
}
