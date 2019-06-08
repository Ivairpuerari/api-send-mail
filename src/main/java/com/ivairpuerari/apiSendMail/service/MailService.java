package com.ivairpuerari.apiSendMail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ivairpuerari.apiSendMail.domain.Body;
import com.ivairpuerari.apiSendMail.domain.User;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail(User user, Body body) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddres());
		mail.setSubject(body.getTitle());
		mail.setText(body.getText());
		
		javaMailSender.send(mail);
	}
	
}
