import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Random;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
        this.users = new ArrayList<>();
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("A user with the same email already exists.");
            }
        }
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }

    public Project<Long> createTask(User user, Project<Long> project, Task task) {
        task.setId(new Random().nextLong());
        task.setAssignee(user);
        project.getTasks().add(task);
        return project;
    }


//    nu stiu sa rezolv eroarea asta : for (Task task : user.getTasks()) {

//        public Task getTask(Long id) throws TaskNotFoundException{
//            for (User user : users) {
//                for (Task task : user.getTasks()) {
//                    if (task.getId().equals(id)) {
//                        return task;
//                    }
//                }
//            }
//            throw new TaskNotFoundException("Task with id " + id + " not found.");
//        }

    public Project<Long> updateTask(Task task, Project<Long> project) throws TaskNotFoundException {
        List<Task> tasks = project.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(task.getId())) {
                tasks.set(i, task);
                return project;
            }
        }
        throw new TaskNotFoundException("Task with id " + task.getId() + " not found.");
    }

    public boolean deleteTask(Long id, Project<Long> project) {
        List<Task> tasks = project.getTasks();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }
}