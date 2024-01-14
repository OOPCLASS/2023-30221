import java.util.List;

interface StorageService<T> {
    List<T> readData();
    void writeData(List<T> data);
}