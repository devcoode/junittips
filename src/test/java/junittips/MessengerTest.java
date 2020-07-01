package junittips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class MessengerTest {

    @Mock
    MailServer mailServer;
    @InjectMocks
    Messenger sut;

    @Test
    @DisplayName("Messenger constructs the SMTP message and feeds MailServer")
    void test() throws IOException {
        String expected = "From: joe@example.com\n"
                + "To: jane@example.com\n\n"
                + "Hello!";

        sut.sendMail("joe@example.com", "jane@example.com", "Hello!");

        Mockito.verify(mailServer).send(expected);
   }
}
