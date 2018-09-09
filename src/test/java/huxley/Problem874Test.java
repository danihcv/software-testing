package huxley;

import huxley.P874_corte_hastes.Problem874;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem874Test extends GenericTest {
    @Test
    void main() throws IOException {
        setUpInputAndExpectedListsFromResources("P874_corte_hastes/");

        if (inputList != null && expectedList != null) {
            for (int i = 0; i < inputList.length; i++) {
                setInputStream(new String(Files.readAllBytes(Paths.get(inputList[i].getPath()))));
                String expected = new String(Files.readAllBytes(Paths.get(expectedList[i].getPath())));
                Problem874.main(new String[]{});
                assertEquals(expected, outContent.toString());
                outContent.reset();
            }
        }
    }
}
