package huxley;

import huxley.P171_reduzindo_mapas.Problem171;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem171Test extends GenericTest {
    private int setUpNormalGraph() {
        setInputStream("5 6\n" +
                "1 2 15\n" +
                "1 3 10\n" +
                "2 3 1\n" +
                "3 4 3\n" +
                "2 4 5\n" +
                "4 5 20\n");

        return 34;
    }

    private int setUpEmptyGraph() {
        setInputStream("0 0\n");

        return 0;
    }

    private int setUpCyclicalGraph() {
        setInputStream("5 5\n" +
                "2 3 2\n" +
                "3 4 3\n" +
                "4 5 4\n" +
                "1 2 1\n" +
                "5 1 5\n");

        return 10;
    }

    private int setUpCyclicalGraphWithSameWeights() {
        setInputStream("10 10\n" +
                "1 2 5\n" +
                "2 3 5\n" +
                "3 4 5\n" +
                "4 5 5\n" +
                "5 6 5\n" +
                "6 7 5\n" +
                "7 8 5\n" +
                "8 9 5\n" +
                "9 10 5\n" +
                "10 1 5\n");
        return 45;
    }

    private int setUpBigGraph() {
        setInputStream("13 21\n" +
                "1 13 7\n" +
                "1 10 10\n" +
                "2 10 20\n" +
                "2 9 5\n" +
                "2 8 30\n" +
                "3 2 45\n" +
                "3 7 5\n" +
                "4 9 51\n" +
                "4 5 13\n" +
                "5 6 2\n" +
                "6 1 8\n" +
                "7 8 3\n" +
                "9 10 6\n" +
                "11 13 3\n" +
                "12 13 21\n" +
                "2 1 100\n" +
                "3 4 70\n" +
                "4 13 28\n" +
                "4 10 1\n" +
                "11 6 3\n" +
                "13 5 74\n");
        return 96;
    }

    @Test
    void main() {
        TestCase[] executables = new TestCase[]{
                this::setUpNormalGraph,
                this::setUpEmptyGraph,
                this::setUpCyclicalGraph,
                this::setUpCyclicalGraphWithSameWeights,
                this::setUpBigGraph
        };

        for (TestCase executable : executables) {
            int expected = (int) executable.setTest();
            Problem171.main(new String[]{});
            assertEquals(expected, Integer.parseInt(outContent.toString()),
                    "Resposta errada! Esperado: (" + expected + "), obtido: (" + outContent.toString() + ")");
            outContent.reset();
        }
    }
}
