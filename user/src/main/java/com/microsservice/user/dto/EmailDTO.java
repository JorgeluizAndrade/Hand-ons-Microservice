package com.microsservice.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDTO {

	private Integer userId;
	private String emailTo;
	private String subject;
	private String text;

}
