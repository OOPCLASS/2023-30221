import java.util.ArrayList;
import java.util.List;

public class InMemoryStorageService<T> implements StorageService<T> {
    private List<T> data;

    public InMemoryStorageService() {
        this.data = new ArrayList<>();
    }

    @Override
    public List<T> readData() {
        return new ArrayList<>(data);
    }

    @Override
    public void writeData(List<T> newData) {
        data = new ArrayList<>(newData);
    }
}
