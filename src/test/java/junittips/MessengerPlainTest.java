package junittips;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MessengerPlainTest {

    MailServer mailServer;
    Messenger sut;

    @BeforeEach
    void setUp() {
        mailServer = mock(MailServer.class);
        sut = new Messenger(mailServer);
    }

    @Test
    @DisplayName("Messenger constructs the content and feeds MailServer")
    void test() throws IOException {
        String expected = "From: joe@example.com\n"
                + "To: jane@example.com\n"
                + "Hello!";

        sut.sendMail("joe@example.com", "jane@example.com", "Hello!");

        verify(mailServer).send(expected);
    }
}
