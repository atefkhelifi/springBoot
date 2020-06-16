package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Mycnstants;



@Controller
public class SimpleEmailExampleController {
	@Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail(@RequestBody String rec) {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo(Mycnstants.FRIEND_EMAIL);
        message.setSubject(Mycnstants.TEXT);
        message.setText(rec);
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
}
