import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks=new ArrayList<Task>();
        Task t=new Task();
        t.setTitle("ex_1");
        t.setStatus(Task.TaskStatus.CREATED);
        tasks.add(t);
        ProjectService PS =new ProjectService();
        PS.create("Colocviu",tasks);
        PS.get(1);
        PS.get(2);
    }
}