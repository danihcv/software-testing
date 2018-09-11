package huxley;

import huxley.P547_profundidade_arvore_binaria.Problem547;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem547Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P547_profundidade_arvore_binaria/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem547.main(new String[]{});
                assertEquals(expected, outContent.toString(), "Falhou no teste: " + inputList[i].getName());
                outContent.reset();
            }
        }
    }
}
