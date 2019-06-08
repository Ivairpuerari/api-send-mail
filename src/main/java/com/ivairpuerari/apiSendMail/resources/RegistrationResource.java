package com.ivairpuerari.apiSendMail.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivairpuerari.apiSendMail.domain.Body;
import com.ivairpuerari.apiSendMail.domain.User;
import com.ivairpuerari.apiSendMail.service.MailService;

@RestController
public class RegistrationResource {
	
	@Autowired
	private MailService notificationServcice;
	
	@Autowired
	private User user;
	
	@Autowired
	private Body body;
	
	@RequestMapping("send-mail")
	public String send(@RequestParam("email") String email, @RequestParam("text") String text, @RequestParam("title") String title) {
		
		body.setTitle(title);
		body.setText(text);
		user.setEmailAddres(email);
		
		try {
			notificationServcice.sendEmail(user, body);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		
		return "Send Mail. Finisehd!";
	}
}
