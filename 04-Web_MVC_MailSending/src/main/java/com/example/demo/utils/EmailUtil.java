package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;
	public boolean sendMail(String to,String subject,String body) {
		
//		SimpleMailMessage message = new SimpleMailMessage();
		try {
//			message.setTo(to);
//			message.setSubject(subject);
//			message.setText(body);
//
//			sender.send(message);
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			sender.send(mimeMessage);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return true;
		
	}

}
