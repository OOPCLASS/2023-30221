package demo.service;

public interface StorageService {

    void save(Object object);

    Object load(String id);
}
