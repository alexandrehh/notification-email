package br.com.notification.email.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.notification.email.NotificationEmail;

@ExtendWith(MockitoExtension.class)
class EmailDtoTest extends NotificationEmail {

    @Override
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEmailDtoCreation() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);

        assertNotNull(emailDto.getEmailTo());
        assertNotNull(emailDto.getEmailFrom());
        assertNotNull(emailDto.getOwnerRef());
        assertNotNull(emailDto.getSubject());
        assertNotNull(emailDto.getText());
    }

    @Test
    void testEqualsAndHashCode() {
        final EmailDto dto1 = gen.nextObject(EmailDto.class);
        final EmailDto dto2 = dto1;
        final EmailDto dto3 = gen.nextObject(EmailDto.class);

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    void testToString() {
        final EmailDto emailDto = gen.nextObject(EmailDto.class);
        final String toString = emailDto.toString();

        assertEquals(toString, "EmailDto(" //
                + "ownerRef=" + emailDto.getOwnerRef() + ", " //
                + "emailFrom=" + emailDto.getEmailFrom() + ", " //
                + "emailTo=" + emailDto.getEmailTo() + ", " //
                + "subject=" + emailDto.getSubject() + ", " //
                + "text=" + emailDto.getText() + ")");

    }
}