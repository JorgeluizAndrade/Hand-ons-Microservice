package com.ms.report.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.report.document.LogEventDocument;
import com.ms.report.dto.LogEventRequest;
import com.ms.report.service.LogEventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/logs")
public class LogEventController {

	private final LogEventService logEventService;

	public LogEventController(LogEventService logEventService) {
		// TODO Auto-generated constructor stub
		this.logEventService = logEventService;
	}

	@PostMapping
	public ResponseEntity<String> saveLog(@Valid @RequestBody LogEventRequest request) {
		try {

			LogEventDocument log = new LogEventDocument(request.getService(), request.getType(),
					request.getDetails());

			logEventService.saveLog(log);

			return ResponseEntity.status(HttpStatus.CREATED).body("Log Salvo");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar log: " + e.getMessage());
		}
	}

}
