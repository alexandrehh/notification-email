package br.com.notification.email.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.notification.email.NotificationEmail;
import br.com.notification.email.models.EmailModel;

class RandomUUIDTest extends NotificationEmail {

    private static final String UUID_REGEX = "[A-Z0-9]{32}";

    @Override
    public void setUp() {
        //
    }

    @Test
    void testUuidFormat() {
        String uuid = RandomUUID.uuid();
        assertNotNull(uuid);
        assertEquals(32, uuid.length());
        assertTrue(uuid.matches(UUID_REGEX));
    }

    @Test
    void testUuidIfNoneSetsIdWhenEmpty() {
        EmailModel entity = new EmailModel();
        entity.setId("");
        RandomUUID.uuidIfNone(entity);
        assertNotNull(entity.getId());
    }
}
