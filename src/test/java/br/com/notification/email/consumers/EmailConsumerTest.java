package br.com.notification.email.consumers;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.notification.email.NotificationEmail;
import br.com.notification.email.dtos.EmailDto;
import br.com.notification.email.services.EmailService;

class EmailConsumerTest extends NotificationEmail {

    @InjectMocks
    private EmailConsumer emailConsumer;
    @Mock
    private EmailService mockEmailService;

    @Override
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        emailConsumer = spy(emailConsumer);
    }

    @Test
    void testListen() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);
        emailConsumer.listen(emailDto);
        verify(mockEmailService).sendEmail(emailDto);
    }
}
