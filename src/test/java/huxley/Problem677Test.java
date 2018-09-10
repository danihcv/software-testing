package huxley;

import huxley.P677_grandes_atalhos.Problem677;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem677Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P677_grandes_atalhos/");

        if (inputList != null  && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(inputList[i]);
                String expected = fileContentToString(expectedList[i]);
                Problem677.main(new String[]{});
                assertEquals(expected, outContent.toString());
                outContent.reset();
            }
        }
    }
}
