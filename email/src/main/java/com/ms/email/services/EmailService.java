package com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.email.entity.Email;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repository.EmailRepository;

@Service
public class EmailService {

	private final EmailRepository emailRepository;
	private final JavaMailSender emailSender;

	public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
		// TODO Auto-generated constructor stub
		this.emailRepository = emailRepository;
		this.emailSender = emailSender;
	}

	@Value(value = "${spring.mail.username}")
	private String emailFrom;

	@Transactional
	public Email sendEmail(Email email) {
		try {
			email.setSendDateEmail(LocalDateTime.now());
			email.setEmailFrom(emailFrom);

			SimpleMailMessage message = new SimpleMailMessage();

			message.setTo(email.getEmailTo());

			message.setSubject(email.getSubject());

			message.setText(email.getText());

			emailSender.send(message);
		
			
			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.SENT);
		} finally {
			return emailRepository.save(email);
		}
	}
}