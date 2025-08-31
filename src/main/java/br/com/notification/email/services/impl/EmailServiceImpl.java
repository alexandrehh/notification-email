package br.com.notification.email.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.enums.StatusEmail;
import br.com.notification.email.models.EmailModel;
import br.com.notification.email.repositories.EmailRepository;
import br.com.notification.email.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;
    
    @Override
    public EmailModel sendEmail(EmailDto emailDto) {
        EmailModel emailModel = createNewEmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);

        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }

        return emailRepository.save(emailModel);
    }

    EmailModel createNewEmailModel() {
        return new EmailModel();
    }
}
