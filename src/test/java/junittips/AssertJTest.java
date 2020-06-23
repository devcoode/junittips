package junittips;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertJTest {

    @Test
    void test() {
        // taken from https://assertj.github.io/doc/
        TolkienCharacter frodo = new TolkienCharacter("Frodo");
        TolkienCharacter sauron = new TolkienCharacter("Sauron");

        // basic assertions
        assertThat(frodo.getName()).isEqualTo("Frodo");
        assertThat(frodo).isNotEqualTo(sauron);

        // chaining string specific assertions
        assertThat(frodo.getName()).startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");

        // exception assertion, standard style ...
        assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
    }

    private static class TolkienCharacter {

        final String name;

        TolkienCharacter(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
}
