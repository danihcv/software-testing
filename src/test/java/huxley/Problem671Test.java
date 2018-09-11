package huxley;

import huxley.P671_bom_amigo_secreto.Problem671;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem671Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P671_bom_amigo_secreto/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem671.main(new String[]{});
                assertEquals(expected, outContent.toString(), "Falhou no teste: " + inputList[i].getName());
                outContent.reset();
            }
        }
    }
}
