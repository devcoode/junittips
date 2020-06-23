package junittips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessengerTest {

    @Mock
    MailServer mailServer;
    @InjectMocks
    Messenger sut;

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
