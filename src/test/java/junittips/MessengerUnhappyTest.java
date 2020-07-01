package junittips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class MessengerUnhappyTest {

    @Mock
    MailServer mailServer;
    @InjectMocks
    Messenger sut;

    @Test
    @DisplayName("Messenger throws UncheckedIOException with the SMTP message when MailServer has thrown IOException")
    void test() throws IOException {
        Mockito.doThrow(new IOException("The server is down")).when(mailServer).send(any());
        String expectedMessage = "From: joe@example.com\n"
                + "To: jane@example.com\n\n"
                + "Hello!";

        assertThatThrownBy(() -> sut.sendMail("joe@example.com", "jane@example.com", "Hello!"))
                .isInstanceOf(UncheckedIOException.class)
                .hasMessage("Error! smtpMessage=%s", expectedMessage)
                .hasCauseInstanceOf(IOException.class);
   }
}
