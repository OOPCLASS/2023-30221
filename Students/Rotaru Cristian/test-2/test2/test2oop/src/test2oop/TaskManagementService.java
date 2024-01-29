package test2oop;

import test2oop.exceptions.DuplicateTaskNameException;
import test2oop.exceptions.EmailAlreadyTakenException;
import test2oop.exceptions.TaskNotFoundException;
import test2oop.exceptions.UserNotFoundException;

import java.util.List;

public class TaskManagementService {

    private ProjectService projectService;
    private List<User<String>> users;

    public TaskManagementService() {
    }

    public TaskManagementService(ProjectService projectService, List<User<String>> users) {
        this.projectService = projectService;
        this.users = users;
    }

    public User<String> createUser(String email) {
        String id = null;
        User<String> user = new User<String>(id, email, null);

        return user;
    }

    public User<String> registerUser (User<String> user) throws EmailAlreadyTakenException {
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        for (User<String> user1 : users) {
            if (user1.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("User with email " + user.getEmail() + " already exists");
            }
        }

        users.add(user);
        return user;
    }

    public Task<Long> createTask(User<Long> user, Project<Long> project, String title) {
        Long id = null;
        Task<Long> task = new Task<Long>(id, title, TaskStatus.CREATED);


        for (Task<Long> task1 : project.getTasks()) {
            if (task1.getTitle().equals(task.getTitle())) {
                throw new DuplicateTaskNameException("Task with title " + title + " already exists");
            }
        }

        user.getTasks().add(task);
        project.getTasks().add(task);

        return task;
    }

    public Task<Long> getTask(Long id) {
        for (User<String> user : users) {
            for (Task<Long> task : user.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }

        throw new TaskNotFoundException("Task with id " + id + " not found");
    }

    public Project<Long> updateTask(Task<Long> task, Project<Long> project, TaskStatus status) {
        if (project.getTasks().contains(task)) {
            task.setStatus(status);
            return project;
        } else {
            throw new TaskNotFoundException("Task not found");
        }
    }

    public boolean deleteTask(Long id) {
        if (getTask(id) == null) {
            throw new TaskNotFoundException("Task not found");
        }

        for (User<String> user : users) {
            for (Task<Long> task : user.getTasks()) {
                if (task.getId().equals(id)) {
                    user.getTasks().remove(task);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Task<Long>> getTasks(Long projectID, TaskStatus status) {
        List<Task<Long>> tasksSearched = null;

        for (Project<Long> project : projectService.getProjects()) {
            if (project.getId().equals(projectID)) {
                for (Task<Long> task : project.getTasks()) {
                    if (task.getStatus().equals(status)) {
                        tasksSearched.add(task);
                    }
                }
            }
        }
        return tasksSearched;
    }


}
