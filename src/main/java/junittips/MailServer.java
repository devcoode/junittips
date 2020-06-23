package junittips;

import java.io.IOException;

class MailServer {
    void send(String content) throws IOException {
        // let's assume there will be SMTP communication here
        System.out.printf("Forwarded to a SMTP server: content=%s\n", content);
    }
}
