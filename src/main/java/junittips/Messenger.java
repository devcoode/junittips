package junittips;

import java.io.IOException;
import java.io.UncheckedIOException;

class Messenger {
    private final MailServer mailServer;
    Messenger(MailServer mailServer) {
        this.mailServer = mailServer;
    }
    void sendMail(String from, String to, String body) {
        String smtpMessage = String.join("\n", "From: " + from, "To: " + to, "", body);
        try {
            mailServer.send(smtpMessage);
        } catch (IOException e) {
            throw new UncheckedIOException("Error! smtpMessage=" + smtpMessage, e);
        }
    }
}
