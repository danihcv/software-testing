package huxley;

import huxley.P200_dentista.Problem200;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Problem200Test extends GenericTest {
    private int setUpNormalAppointments() {
        setInputStream("3\n" +
                "120 200\n" +
                "10 100\n" +
                "40 130\n");
        return 2;
    }

    private int setUpNoCollisionAppointments() {
        setInputStream("15\n" +
                "10 25\n" +
                "25 30\n" +
                "30 55\n" +
                "55 1000\n" +
                "1000 1001\n" +
                "1001 2000\n" +
                "2000 2500\n" +
                "2508 2769\n" +
                "2769 3000\n" +
                "3002 3741\n" +
                "3741 3900\n" +
                "3907 4000\n" +
                "4100 4101\n" +
                "4111 4500\n" +
                "4560 5000\n");
        return 15;
    }

    private int setUpSomeCollisionsAppointments() {
        setInputStream("13\n" +
                "10 500\n" +
                "10 20\n" +
                "10 30\n" +
                "10 88\n" +
                "89 100\n" +
                "89 95\n" +
                "100 140\n" +
                "100 500\n" +
                "115 200\n" +
                "200 250\n" +
                "200 220\n" +
                "220 250\n" +
                "250 259\n");
        return 6;
    }

    private int setUpAlwaysCollideAppointments() {
        setInputStream("20\n" +
                "20 700\n" +
                "20 25\n" +
                "20 30\n" +
                "20 22\n" +
                "20 100\n" +
                "20 250\n" +
                "20 310\n" +
                "20 740\n" +
                "20 110\n" +
                "20 50\n" +
                "20 987\n" +
                "20 311\n" +
                "20 22\n" +
                "20 73\n" +
                "20 737\n" +
                "20 98\n" +
                "20 36\n" +
                "20 963\n" +
                "20 164\n" +
                "20 970\n");
        return 1;
    }

    private int setUpALotOfCollisionsAppointments() throws IOException {
        setInputStream(new String(Files.readAllBytes(Paths.get("src/test/resources/P200_dentista/manyCollisions.txt"))));
        return 4;
    }

    @Test
    void main() throws IOException {
        TestCase[] testCases = new TestCase[]{
                this::setUpNormalAppointments,
                this::setUpNoCollisionAppointments,
                this::setUpSomeCollisionsAppointments,
                this::setUpAlwaysCollideAppointments,
                this::setUpALotOfCollisionsAppointments
        };

        String[] assertMessages = new String[]{
                "Falhou com uma grade pequena de consultas com colisão",
                "Falhou com uma grade de consultas sem colisões",
                "Falhou com uma grade regular de consultas com algumas colisões",
                "Falhou com uma grade de consultas que sempre colidem",
                "Falhou com uma grade grande de consultas com muitas colisões"
        };

        for (int i = 0; i < testCases.length; i++) {
            int expected = (int) testCases[i].setTest();
            Problem200.main(new String[]{});
            assertEquals(expected, Integer.parseInt(outContent.toString()), assertMessages[i]);
            outContent.reset();
        }
    }
}
