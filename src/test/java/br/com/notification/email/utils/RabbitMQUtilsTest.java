package br.com.notification.email.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.amqp.core.Queue;

import br.com.notification.email.NotificationEmail;

class RabbitMQUtilsTest extends NotificationEmail {

    @InjectMocks
    private RabbitMQUtils rabbitMQUtils;

    @Override
    public void setUp() {
        rabbitMQUtils = spy(rabbitMQUtils);
    }

    @Test
    void testQueue() {
        final String queueName = "test-queue";
        setField(rabbitMQUtils, "queue", queueName);

        final Queue queue = rabbitMQUtils.queue();

        assertEquals(queueName, queue.getName());
        assertTrue(queue.isDurable());
    }

    @Test
    void testMessageConverter() {
        assertNotNull(rabbitMQUtils.messageConverter());
    }
}