package br.com.notification.email;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class NotificationEmail {

    protected EasyRandom gen = new EasyRandom();
    protected AutoCloseable closable = null;

    @BeforeEach
    public final void before() {
        closable = openMocks();
        setUp();
    }

    public abstract void setUp();

    public AutoCloseable openMocks() {
        return MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() throws Exception {
        closable.close();
    }
}
