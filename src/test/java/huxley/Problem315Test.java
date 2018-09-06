package huxley;

import huxley.P315_nomes_produzem_cores.Problem315;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Problem315Test extends GenericTest {
    @Test
    void hexToDecimal() {
        String[] testCases = new String[] {
                "dead",
                "04513",
                "cafe",
                "dad100",
                "100dad",
                "6973",
                "a0b1c2d3e4f5",
                "aaaaa",
                "aff"
        };

        int[] expected = new int[]{};
    }

    @Test
    void main() {
        String[] testCases = new String[] {
                "ChuckNORRIS",
                "JAcARE",
                "C",
                "CAfE",
                "DEaD",
                "Daniel",
                "Willy",
                "amorim"
        };

        String[] expected = new String[] {
                "(192,0,0)",
                "(10,202,14)",
                "(12,0,0)",
                "(202,254,0)",
                "(222,173,0)",
                "(218,0,224)",
                "(0,0,0)",
                "(160,0,0)"
        };

        for (int i = 0; i < testCases.length; i++) {
            setInputStream(testCases[i]);
            Problem315.main(new String[]{});
            assertEquals(expected[i], outContent.toString());
            outContent.reset();
        }
    }
}
