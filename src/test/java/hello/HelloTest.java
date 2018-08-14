package hello;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testHello() {
        Hello h = new Hello();
        assertNotNull(h, "Hello is null");

        assertAll(
                () -> assertNull(get("text1", h)),
                () -> assertNull(get("text2", h)));

        h.sayHello();
        assertEquals("Hello World!" + System.lineSeparator(), outContent.toString(), "Strings arent equal");

        assertAll(
                () -> assertEquals("Hello", get("text1", h)),
                () -> assertEquals("World!", get("text2", h)));
    }

    private String get(String name, Hello obj) {
        try {
            Field f = Hello.class.getDeclaredField(name);
            f.setAccessible(true);

            return (String) f.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
