import java.io.*;
import java.util.List;

public class FileStorageService<T> implements StorageService<T> {
    private String filePath;

    public FileStorageService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<T> readData() {
        List<T> data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            data = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void writeData(List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
