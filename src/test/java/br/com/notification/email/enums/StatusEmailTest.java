package br.com.notification.email.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatusEmailTest {

    @Test
    void testSentStatus() {
        StatusEmail status = StatusEmail.SENT;
        assertEquals("SENT", status.name());
    }

    @Test
    void testErrorStatus() {
        StatusEmail status = StatusEmail.ERROR;
        assertEquals("ERROR", status.name());
    }
}
