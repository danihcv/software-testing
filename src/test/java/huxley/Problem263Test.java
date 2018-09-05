package huxley;

import huxley.P263_intersecao_listas.Problem263;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem263Test extends GenericTest {
    String setUpSimpleIntersec() {
        String testCase = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "25\n" +
                "26\n" +
                "27\n" +
                "28\n" +
                "29\n";
        setInputStream(testCase);

        return "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20";
    }

    String setUpFirstAndLastIntersec() {
        String testCase = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "20\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "1\n";
        setInputStream(testCase);

        return "1\n20";
    }

    String setUpEmptyIntersec() {
        String testCase = "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "2\n";
        setInputStream(testCase);

        return "VAZIO";
    }

    String setUpSingleElementIntersec() {
        String testCase = "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n";
        setInputStream(testCase);

        return "1";
    }

    @Test
    void main() {
        String expected = setUpSimpleIntersec();
        Problem263.main(new String[]{});
        assertEquals(expected, outContent.toString(), "Interseção de 10 itens falhou");
        outContent.reset();

        expected = setUpFirstAndLastIntersec();
        Problem263.main(new String[]{});
        assertEquals(expected, outContent.toString(),
                "Intersão do primeiro elemento de um array com o último do outro, e vice-versa, falhou");
        outContent.reset();

        expected = setUpEmptyIntersec();
        Problem263.main(new String[]{});
        assertEquals(expected, outContent.toString(), "Interseção vazia não indentificada");
        outContent.reset();

        expected = setUpSingleElementIntersec();
        Problem263.main(new String[]{});
        assertEquals(expected, outContent.toString(), "Interseção com elemento único repetido várias vezes falhou");
        outContent.reset();
    }
}
