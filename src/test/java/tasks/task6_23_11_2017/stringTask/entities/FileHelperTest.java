package tasks.task6_23_11_2017.stringTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileHelperTest {

    private static String validFilePath;
    private static String invalidFilePath;

    @BeforeAll
    static void initializeComponents() {
        validFilePath = "src\\main\\java\\tasks\\task6_23_11_2017\\stringTask\\additional\\text";
        invalidFilePath = "src\\main\\java\\tasks\\task6_23_11_2017\\stringTask\\additional\\text1";
    }

    @AfterAll
    static void nullifyComponents() {
        validFilePath = null;
        invalidFilePath = null;
    }

    @Test
    void getFileBytes() {
        byte[] result = FileHelper.getFileBytes(validFilePath);
        assertTrue(result != null);
    }

    @Test
    void getFileBytes1() {
        byte[] result = FileHelper.getFileBytes(invalidFilePath);
        assertTrue(result == null);
    }
}