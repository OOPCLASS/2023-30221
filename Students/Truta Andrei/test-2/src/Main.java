import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //Abstract so you cannot instantiate it
        //AbstractEntity<Integer> ae = new AbstractEntity<Integer>();

        TaskManagementService tms = new TaskManagementService();
        Project p1 = tms.getProjectService().create("Unit test project");
        Project p2 = tms.getProjectService().create("Angular project");

        Project p3 = tms.getProjectService().create("Deleted project");
        tms.getProjectService().delete(p3);

        Project p2get = tms.getProjectService().get(p2.getId());
        assert (p2get.equals(p2));

        User u1 = tms.registerUser(new User("user1@gmail.com"));
        User u2 = tms.registerUser(new User("user2@gmail.com"));

        Task t1 = tms.createTask("Do unit tests", u1, p1);
        Task t1u = new Task("Do unit tests");

        t1u.setStatus(TaskStatus.IN_PROGRESS);
        tms.updateTask(t1.getId(), t1u);

        //Cannot delete because of t1 in progress
        //tms.getProjectService().delete(p1);

        //Can delete now because of t1u in progress for more than 6 months (uncommenting this will throw an exception later, make sure
        // to comment what's below)
//        p1.setCreatedAt(LocalDateTime.now().minusMonths(8));
//        tms.getProjectService().delete(p1);

        
        //tms.deleteTask(t1.getId());

        Task t1get = tms.getTask(t1.getId());
        assert (t1get.equals(t1u));

        Task t2 = tms.createTask("Other stuff", u1, p2);
        Task t3 = tms.createTask("Change button styles", u2, p2);
        Task t4 = tms.createTask("Create unit project", u2, p1);

        List<Task> taskList = tms.getTasks(p2.getId(), TaskStatus.CREATED);
        System.out.println("Tasks for project \"" + p2.getTitle() + "\":");
        for (Task task : taskList) {
            System.out.println(task);
        }

        System.out.println();

        Map<Task, Project> otherTaskList = tms.getTasks(TaskStatus.CREATED);
        System.out.println("Tasks for all projects with status CREATED:");
        for (Map.Entry<Task, Project> entry : otherTaskList.entrySet()) {
            Task task = entry.getKey();
            Project project = entry.getValue();
            System.out.println("Task: " + task + ", Project: " + project);
        }
    }
}