package com.ms.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dto.EmailDTO;
import com.ms.email.entity.Email;
import com.ms.email.services.EmailService;

@Component
public class EmailConsumer {

	private final EmailService emailService;

	public EmailConsumer(EmailService emailService) {
		// TODO Auto-generated constructor stub
		this.emailService = emailService;
	}

	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailDTO emailRecordDTO) {
		var email = new Email();

		BeanUtils.copyProperties(emailRecordDTO, email);
		
		emailService.sendEmail(email);

	}
}
