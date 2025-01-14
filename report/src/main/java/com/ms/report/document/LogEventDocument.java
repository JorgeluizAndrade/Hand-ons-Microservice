package com.ms.report.document;

import java.time.Instant;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collation = "logs")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogEventDocument {
	@Id
	private String id;
	
	private Instant timestamp;
	
	private String type;
	
	private String service;
	
	private String details;
	
	
    public LogEventDocument(String service, String type, String details) {
        this.timestamp = Instant.now();
        this.service = service;
        this.type = type;
        this.details = details;
    }

}
