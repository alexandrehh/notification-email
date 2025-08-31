package br.com.notification.email.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.notification.email.NotificationEmail;
import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.models.EmailModel;
import br.com.notification.email.services.EmailService;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest extends NotificationEmail {

    @InjectMocks
    private EmailController emailController;
    @Mock
    private EmailService mockEmailService;

    @Override
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        emailController = spy(emailController);
    }

    @Test
    void testSendEmail() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);
        final EmailModel emailModel = gen.nextObject(EmailModel.class);

        when(mockEmailService.sendEmail(emailDto)).thenReturn(emailModel);

        ResponseEntity<EmailModel> output = emailController.sendEmail(emailDto);

        assertEquals(HttpStatus.CREATED, output.getStatusCode());
        assertEquals(emailModel, output.getBody());
    }
}