package huxley;

import huxley.P862_maior_sequencia.Problem862;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem862Test extends GenericTest {
    @Test
    void main() {
        setInputStream("01100010\n0");
        String expected = "3 5\n";
        Problem862.main(new String[]{});
        assertEquals(expected, outContent.toString());
        outContent.reset();

        setInputStream("00000\n01010101\n0");
        expected = "0 4\n0 0\n";
        Problem862.main(new String[]{});
        assertEquals(expected, outContent.toString());
        outContent.reset();

        setInputStream("1\n01\n11111110\n0");
        expected = "-1 -1\n0 0\n7 7\n";
        Problem862.main(new String[]{});
        assertEquals(expected, outContent.toString());
        outContent.reset();

        setInputStream("0");
        expected = "";
        Problem862.main(new String[]{});
        assertEquals(expected, outContent.toString());
        outContent.reset();
    }
}
