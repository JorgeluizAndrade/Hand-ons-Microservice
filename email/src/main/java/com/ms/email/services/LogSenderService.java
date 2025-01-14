package com.ms.email.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.ms.email.dto.LogSendRequest;

@Service
public class LogSenderService {

	private final RabbitTemplate rabbitTemplate;

	public LogSenderService(RabbitTemplate rabbitTemplate) {
		// TODO Auto-generated constructor stub
		this.rabbitTemplate = rabbitTemplate;
	}
		
	public void sendLog(String eventType, String serviceName, String details) {
		LogSendRequest logEventRequest = new LogSendRequest(eventType, serviceName, details);
		
		rabbitTemplate.convertAndSend("logExchange", "logsQueue", logEventRequest);
        System.out.println("Log enviado para a fila RabbitMQ: " + logEventRequest);
	}

	}
