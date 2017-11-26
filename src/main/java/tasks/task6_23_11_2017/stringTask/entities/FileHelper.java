package tasks.task6_23_11_2017.stringTask.entities;

import java.io.FileInputStream;
import java.io.IOException;

public class FileHelper {

    public static byte[] getFileBytes(String path) {

        byte[] buffer = null;
        try (FileInputStream fin = new FileInputStream(path)) {

            buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            return buffer;
        }
    }
}
