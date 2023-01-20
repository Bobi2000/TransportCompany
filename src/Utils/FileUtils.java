package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeObjectsToFile(String fileName, List<?> objects) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Object object : objects) {
                oos.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> readObjectsFromFile(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                objects.add(ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }
}