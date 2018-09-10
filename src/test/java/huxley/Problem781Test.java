package huxley;

import huxley.P781_matriz_aleatoria.Problem781;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem781Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P781_matriz_aleatoria/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem781.main(new String[]{});
                assertEquals(expected, outContent.toString());
                outContent.reset();
            }
        }
    }
}
