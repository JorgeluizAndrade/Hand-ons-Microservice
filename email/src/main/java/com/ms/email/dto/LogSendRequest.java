package com.ms.email.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LogSendRequest {
	private String service;

	private String type;

	private String details;

	public LogSendRequest(String service, String type, String details) {
		this.service = service;
		this.type = type;
		this.details = details;

	}
}
