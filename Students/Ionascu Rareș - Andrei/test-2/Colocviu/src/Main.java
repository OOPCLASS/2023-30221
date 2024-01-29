public class Main {
    public static void main(String[] args) {
        // Create a ProjectService instance
        ProjectService projectService = new ProjectService();

        // Create a new Project
        Project project = new Project("Project 1");
        projectService.createProject(project);

        // Create a new Task
        Task task = new Task("Task 1", "This is task 1", TaskStatus.IN_PROGRESS);
        project.addTask(task);

        task.setStatus(TaskStatus.COMPLETED);

        Task task1 = new Task("Task2", "This is task 2", TaskStatus.COMPLETED);
        project.addTask(task);






        // Create a new User and register it
        User user = new User(1, "user1@example.com", "User 1");
        TaskManagementService taskManagementService = new TaskManagementService();
        try {
            taskManagementService.registerUser(user);
        } catch (EmailAlreadyTakenException e) {
            e.printStackTrace();
        }

        // Add the user to the project
        project.addUser(user);

        // Print all tasks in the project
        for (Task t : project.getTasks()) {
            System.out.println("Task title: " + t.getTitle());
            System.out.println("Task description: " + t.getDescription());
            System.out.println("Task status: " + t.getStatus());
        }

        // Print all users in the project
        for (User u : project.getUsers()) {
            System.out.println("User email: " + u.getEmail());
            System.out.println("User name: " + u.getName());
        }


    }

}