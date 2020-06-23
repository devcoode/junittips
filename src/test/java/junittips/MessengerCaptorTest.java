package junittips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // @RunWith(MockitoJUnitRunner.class) for JUnit4
class MessengerCaptorTest {

    @Mock
    MailServer mailServer;
    @Captor
    ArgumentCaptor<String> captor;
    @InjectMocks
    Messenger sut;

    @Test
    @DisplayName("Messenger constructs the content and feeds MailServer")
    void test() throws IOException {
        sut.sendMail("joe@example.com", "jane@example.com", "Hello!");

        verify(mailServer).send(captor.capture());
        assertTrue(captor.getValue().endsWith("Hello!"));
    }
}
