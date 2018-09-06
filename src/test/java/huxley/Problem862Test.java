package huxley;

import huxley.P862_maior_sequencia.Problem862;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem862Test extends GenericTest {
    @Test
    void main() {
        String[] testCases = new String[] {
                "01100010\n0",
                "00000\n01010101\n0",
                "1\n01\n11111110\n0",
                "0"
        };

        String[] expected = new String[] {
                "3 5\n",
                "0 4\n0 0\n",
                "-1 -1\n0 0\n7 7\n",
                ""
        };

        for (int i = 0; i < testCases.length; i++) {
            setInputStream(testCases[i]);
            Problem862.main(new String[]{});
            assertEquals(expected[i], outContent.toString());
            outContent.reset();
        }
    }
}
