package huxley;

import huxley.P1021_super_sales.Problem1021;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem1021Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P1021_super_sales/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem1021.main(new String[]{});
                assertEquals(expected, outContent.toString(), "Falhou no teste: " + inputList[i].getName());
                outContent.reset();
            }
        }
    }
}
