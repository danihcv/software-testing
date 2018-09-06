package huxley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

abstract class GenericTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private final InputStream originalIn = System.in;

    interface TestCase<T> {
        T setTest() throws IOException;
    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    void setInputStream(String inputStr) {
        byte[] testBytes = inputStr.getBytes();
        InputStream input = new ByteArrayInputStream(testBytes);
        System.setIn(input);
    }
}
