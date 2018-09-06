package huxley;

import huxley.P263_intersecao_listas.Problem263;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem263Test extends GenericTest {
    private String setUpSimpleIntersec() {
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

    private String setUpFirstAndLastIntersec() {
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

    private String setUpEmptyIntersec() {
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

    private String setUpSingleElementIntersec() {
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
        TestCase[] testCases = new TestCase[] {
                this::setUpSimpleIntersec,
                this::setUpFirstAndLastIntersec,
                this::setUpEmptyIntersec,
                this::setUpSingleElementIntersec
        };

        String[] assertMessages = new String[]{
                "Interseção de 10 itens falhou",
                "Intersão do primeiro elemento de um array com o último do outro, e vice-versa, falhou",
                "Interseção vazia não indentificada",
                "Interseção com elemento único repetido várias vezes falhou"
        };

        for (int i = 0; i < testCases.length; i++) {
            String expected = (String) testCases[i].setTest();
            Problem263.main(new String[]{});
            assertEquals(expected, outContent.toString(), assertMessages[i]);
            outContent.reset();
        }
    }
}
