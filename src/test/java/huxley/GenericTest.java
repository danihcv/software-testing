package huxley;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class GenericTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    String resourcesPath = "src/test/resources/";
    File[] inputList;
    File[] expectedList;

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

    void setInputStream(File file) throws IOException {
        setInputStream(fileContentToString(file));
    }

    void setUpInputAndExpectedListsFromResources(String folder) {
        File dir = new File(resourcesPath + folder);
        FileFilter fileInputFilter = new WildcardFileFilter("*.in", IOCase.INSENSITIVE);
        FileFilter fileOutputFilter = new WildcardFileFilter("*.out", IOCase.INSENSITIVE);
        inputList = dir.listFiles(fileInputFilter);
        expectedList = dir.listFiles(fileOutputFilter);
    }

    String fileContentToString(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.getPath()))).replaceAll("\r\n|\r|\n", System.lineSeparator());
    }
}
