package br.com.notification.email.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.com.notification.email.NotificationEmail;
import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.enums.StatusEmail;
import br.com.notification.email.models.EmailModel;
import br.com.notification.email.repositories.EmailRepository;

class EmailServiceImplTest extends NotificationEmail {

    @InjectMocks
    private EmailServiceImpl emailService;
    @Mock
    private EmailRepository mockEmailRepository;
    @Mock
    private JavaMailSender mockEmailSender;

    @Override
    public void setUp() {
        emailService = spy(emailService);
    }

    @Test
    void testSendEmail() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);
        final EmailModel emailModel = gen.nextObject(EmailModel.class);

        emailModel.setStatusEmail(StatusEmail.SENT);

        doReturn(emailModel).when(emailService).createNewEmailModel();
        when(mockEmailRepository.save(emailModel)).thenReturn(emailModel);

        final EmailModel output = emailService.sendEmail(emailDto);

        assertEquals(emailModel.getId(), output.getId());
        assertEquals(emailModel.getSendDateEmail(), output.getSendDateEmail());
        assertEquals(emailModel.getSubject(), output.getSubject());
        assertEquals(emailModel.getEmailFrom(), output.getEmailFrom());
        assertEquals(emailModel.getEmailTo(), output.getEmailTo());
        assertEquals(emailModel.getText(), output.getText());
        assertEquals(emailModel.getStatusEmail(), output.getStatusEmail());

        verify(mockEmailRepository).save(emailModel);
        verify(mockEmailSender).send((SimpleMailMessage) any());
    }

    @Test
    void testSendEmailNotSend() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);
        final EmailModel emailModel = gen.nextObject(EmailModel.class);
        final MailSendException mailSendException = new MailSendException("Failed to send email");

        emailModel.setStatusEmail(StatusEmail.ERROR);

        doReturn(emailModel).when(emailService).createNewEmailModel();
        when(mockEmailRepository.save(emailModel)).thenReturn(emailModel);
        doThrow(mailSendException).when(mockEmailSender).send((SimpleMailMessage) any());

        final EmailModel output = emailService.sendEmail(emailDto);

        assertEquals(emailModel.getId(), output.getId());
        assertEquals(emailModel.getSendDateEmail(), output.getSendDateEmail());
        assertEquals(emailModel.getSubject(), output.getSubject());
        assertEquals(emailModel.getEmailFrom(), output.getEmailFrom());
        assertEquals(emailModel.getEmailTo(), output.getEmailTo());
        assertEquals(emailModel.getText(), output.getText());
        assertEquals(emailModel.getStatusEmail(), output.getStatusEmail());

        verify(mockEmailRepository).save(emailModel);
        verify(mockEmailSender).send((SimpleMailMessage) any());
    }

    @Test
    void testCreateNewEmailModel() {
        final EmailModel emailModel = emailService.createNewEmailModel();
        assertEquals(EmailModel.class, emailModel.getClass());
    }
}
