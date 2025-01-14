package com.ms.report.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ms.report.document.LogEventDocument;
import com.ms.report.dto.LogEventRequest;
import com.ms.report.service.LogEventService;

@Component
public class LogEventConsumer {

	private final LogEventService logEventService;

	public LogEventConsumer(LogEventService logEventService) {
		// TODO Auto-generated constructor stub
		this.logEventService = logEventService;
	}

	@RabbitListener(queues = "${broker.queue.logs.name}")
	public void receiveLog(LogEventRequest request) {
		LogEventDocument logEvent = new LogEventDocument(request.getService(), request.getType(), request.getDetails());
		
		logEventService.saveLog(logEvent);
		System.out.println("Log recebido e salvo com sucesso");
	}
}
