package tasks.task6_23_11_2017.stringTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.helpers.FileHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class FileHelperTest {

    private static String validFilePath;
    private static String invalidFilePath;

    @BeforeAll
    static void initializeComponents() {
        validFilePath = "src\\main\\java\\tasks\\task6_23_11_2017\\stringTask\\additional\\TextExample";
        invalidFilePath = "src\\main\\java\\tasks\\task6_23_11_2017\\stringTask\\additional\\text1";
    }

    @AfterAll
    static void nullifyComponents() {
        validFilePath = null;
        invalidFilePath = null;
    }

    @Test
    void getFileBytes() {
        try {
            byte[] result = FileHelper.getFileBytes(validFilePath);
            assertTrue(result != null);
        } catch (IOException e) {
            fail("invalid file path");
        }
    }

    @Test
    void getFileBytes1() {
        try {
            byte[] result = FileHelper.getFileBytes(invalidFilePath);
//            assertTrue(result == null);
        } catch (IOException e) {
            fail("invalid file path");
        }
    }
}