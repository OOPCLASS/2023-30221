import java.util.ArrayList;
import java.util.List;

public class User<String> extends AbstractEntity<String> {
    private String email;
    List<Task<Long>> tasks = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }
}
