package com.ecommerce.farmmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithImage(String to, String subject, String text, byte[] imageBytes, String imageName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("botboyramu@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true); // Set 'true' to send HTML content

        // Attach image if available
        if (imageBytes != null) {
            helper.addAttachment(imageName, new ByteArrayResource(imageBytes));
        }

        mailSender.send(message);
        System.out.println("Order email with image sent successfully.");
    }
}
