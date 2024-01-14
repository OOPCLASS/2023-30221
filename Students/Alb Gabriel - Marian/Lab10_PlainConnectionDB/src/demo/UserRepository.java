package demo;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Long, User> users = new HashMap<>();

    public UserRepository() {
    }

    public User save(User user) {
        user.setId(users.size() + 1L);
        user.setPassword(user.getPassword());
        users.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User findByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User update(User user) {
        if (users.containsKey(user.getId())) {
            user.setPassword(user.getPassword());
            users.put(user.getId(), user);
            return user;
        }
        return null;
    }

    public void deleteById(Long id) {
        users.remove(id);
    }
}
