package ma.yc.api.services.impl;

import ma.yc.api.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    private static final String NOREPLY_ADDRESS = "noreply@baeldung.com";

//    @Autowired
//    private JavaMailSender emailSender;

//    @Autowired
//
//    private SimpleMailMessage template;
    @Override
    public void sendSimpleMessage(String to, String subject, String text) {

    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) {

    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {

    }
}
