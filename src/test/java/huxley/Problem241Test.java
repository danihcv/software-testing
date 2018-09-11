package huxley;

import huxley.P241_marmore.Problem241;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem241Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P241_marmore/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem241.main(new String[]{});
                assertEquals(expected, outContent.toString(), "Falhou no teste: " + inputList[i].getName());
                outContent.reset();
            }
        }
    }
}
