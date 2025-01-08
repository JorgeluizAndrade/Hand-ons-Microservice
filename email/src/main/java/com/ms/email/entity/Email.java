package com.ms.email.entity;

import java.time.LocalDateTime;

import com.ms.email.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_EMAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer emailId;

	private Integer userId;

	private String emailFrom;

	private String emailTo;

	private String subject;
	@Column(columnDefinition = "TEXT")
	private String text;

	private LocalDateTime sendDateEmail;

	private StatusEmail statusEmail;

}
