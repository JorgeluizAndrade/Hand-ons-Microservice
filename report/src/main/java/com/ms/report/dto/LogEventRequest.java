package com.ms.report.dto;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LogEventRequest {	
	
    @NotBlank(message = "O campo 'service' é obrigatório.")
    private String service;

    @NotBlank(message = "O campo 'type' é obrigatório.")
    private String type;

    private String details;

}	
