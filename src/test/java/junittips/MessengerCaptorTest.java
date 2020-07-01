package junittips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class) // @RunWith(MockitoJUnitRunner.class) for JUnit4
class MessengerCaptorTest {

    @Mock
    MailServer mailServer;
    @InjectMocks
    Messenger sut;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    @DisplayName("Messenger constructs the SMTP message and feeds MailServer")
    void test() throws IOException {
        sut.sendMail("joe@example.com", "jane@example.com", "Hello!");

        Mockito.verify(mailServer).send(captor.capture());
        String capturedValue = captor.getValue();
        assertTrue(capturedValue.endsWith("Hello!"));
    }
}
