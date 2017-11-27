package tasks.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {

    public static byte[] getFileBytes(String path) throws IOException {

        byte[] buffer;
        try (FileInputStream fin = new FileInputStream(path)) {
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());
            return buffer;
        } catch (IOException ex) {
            throw new IOException("Bad file path given.");
        }
    }

    public static void writeToFile(byte[] bytes, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
