package com.ivairpuerari.apiSendMail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	public void sendEmailWithAttachment(User user) throws MailException, MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setTo(user.getEmailAddres());
		
		helper.setSubject("Testing Mail API with Attachment");
		
		helper.setText("Hey, this is a text, have a funny! Please find the attached document below.");
		
		ClassPathResource classPathResource = new ClassPathResource("test.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);
		
		javaMailSender.send(mimeMessage);
	}
	
}
