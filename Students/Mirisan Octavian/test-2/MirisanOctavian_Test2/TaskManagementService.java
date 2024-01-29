import java.util.ArrayList;
import java.util.List;

public class TaskManagementService
{

    private ProjectService projectService;

    private List<User> users;


    public TaskManagementService()
    {
        this.projectService = new ProjectService();
        this.users = new ArrayList<>();
    }

    public ProjectService getProjectService()
    {
        return projectService;
    }

    public void setProjectService(ProjectService projectService)
    {
        this.projectService = projectService;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }



    public User registerUser(User user) throws Exceptions.EmailAlreadyTakenException {
        for (User existingUser : users)
        {
            if (existingUser.getEmail().equals(user.getEmail()))
            {
                throw new Exceptions.EmailAlreadyTakenException("Email " + user.getEmail() + " is already in use.");
            }
        }

        Long id = generateId();

        user.setId(id);
        users.add(user);

        return user;
    }



    public Project createTask(User user, Project project) throws Exceptions.UserNotFoundException
    {
        if (!users.contains(user))
        {
            throw new Exceptions.UserNotFoundException("User does not exist.");
        }

        Task newTask = new Task(generateId(), "Default Task", TaskStatus.CREATED);
        project.getTasks().add(newTask);

        projectService.update(String.valueOf(project.getId()), project);

        return project;
    }




    public Task getTask(Long id) throws Exceptions.TaskNotFoundException
    {
        for (User user : users)
        {
            for (Task task : user.getTasks())
            {
                if (task.getId().equals(id))
                {
                    return task;
                }
            }
        }
        throw new Exceptions.TaskNotFoundException("Task with ID " + id + " does not exist.");
    }




    public Project updateTask(Task task, Project project) throws Exceptions.TaskNotFoundException
    {

        if(!project.getTasks().contains(task))
        {
            throw new Exceptions.TaskNotFoundException("Task does not exist");
        }

        for (Task projectTask : project.getTasks())
        {
            if (projectTask.getId().equals(task.getId()))
            {
                projectTask.setTitle(task.getTitle());
                projectTask.setStatus(task.getStatus());
                break;
            }
        }

        projectService.update(String.valueOf(project.getId()), project);

        return project;
    }


    public boolean deleteTask(Long id)
    {

        for (User user : users)
        {

            for (Task task : user.getTasks())
            {
                if (task.getId().equals(id))
                {
                    return user.getTasks().remove(task);
                }
            }
        }
        return false;
    }


    public List<Task> getTasks(Long projectId, TaskStatus status)
    {
        List<Task> resultTasks = new ArrayList<>();

        for (User user : users)
        {
            for (Task task : user.getTasks())
            {
                if (task.getStatus() == status && projectService.get(String.valueOf(projectId)).getTasks().contains(task))
                {
                    resultTasks.add(task);
                }
            }
        }

        return resultTasks;
    }



    private Long generateId()
    {
        return Long.valueOf(System.currentTimeMillis());
    }

}
