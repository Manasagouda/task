  package com.order.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.order.entities.Customer;
import com.order.entities.Order;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sendMail;
	public void sendOrderConfirmationEmail(Customer customer, Order order) {
	    try {
	        MimeMessage message = sendMail.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(customer.getEmail());
	        helper.setSubject("Order Confirmation - Order #" + order.getId());
	        helper.setText("IF You have place 10 orders then you will be\r\n"
	        		+ "promoted to Gold customer and enjoy 10% discounts!"); 
	sendMail.send(message);
	    }catch (MessagingException e) {
	        e.printStackTrace();
	    }

	}
}
