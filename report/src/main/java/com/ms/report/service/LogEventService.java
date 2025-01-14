	package com.ms.report.service;

import org.springframework.stereotype.Service;

import com.ms.report.document.LogEventDocument;
import com.ms.report.repository.LogEventRepository;

@Service
public class LogEventService {

	private final LogEventRepository logRepository;

	public LogEventService(LogEventRepository logRepository) {
		// TODO Auto-generated constructor stub
		this.logRepository = logRepository;
	}

	public LogEventDocument saveLog(LogEventDocument logEvent) {
		logEvent = logRepository.save(logEvent);

		return logEvent;
	}
}
