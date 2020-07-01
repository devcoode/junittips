package junittips;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

class MessengerPlainTest {

    MailServer mailServer;
    Messenger sut;

    @BeforeEach
    void setUp() {
        mailServer = Mockito.mock(MailServer.class);
        sut = new Messenger(mailServer);
    }

    @Test
    @DisplayName("Messenger constructs the SMTP message and feeds MailServer")
    void test() throws IOException {
        String expected = "From: joe@example.com\n"
                + "To: jane@example.com\n\n"
                + "Hello!";

        sut.sendMail("joe@example.com", "jane@example.com", "Hello!");

        verify(mailServer).send(expected);
    }
}
