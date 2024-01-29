package test_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
	 private List<Project> projects = new ArrayList<>();

	    // Create a new project
	    public Project create(String title) {
	    	if (isDuplicateProjectName(title)) {
	            throw new RuntimeException("DuplicateProjectNameException: Project with the same name already exists: " + title);
	        }
	        Project newProject = new Project(title);
	        projects.add(newProject);
	        return newProject;
	    }

	    // Delete a project by ID
	    public boolean delete(Long projectId) {
	        Project projectToDelete = findProjectById(projectId);
	        if (projectToDelete == null) {
	            throw new RuntimeException("Project not found with ID: " + projectId);
	        }
	        if (hasInProgressTasks(projectToDelete.getTasks())) {
             return false;
	        }
	        if (isMoreThanSixMonths(projectToDelete.getCreatedDate())) {
	            projects.remove(projectToDelete);
	            System.out.println("Project with ID " + projectId + " deleted successfully.");
	        } else {
	            throw new RuntimeException("Cannot delete project with ID " + projectId +
	                    ". It has been less than 6 months since project creation.");
	        }
	        return true;
	    }

	    // Get a project by ID
	    public Project get(Long projectId) {
	    	Project project = findProjectById(projectId);
	        if (project == null) {
	            throw new RuntimeException("ProjectNotFoundException: Project not found with ID: " + projectId);
	        }
	        return findProjectById(projectId);
	    }

	  
	    public void update(Long projectId, Project updatedProject) {
	        Project existingProject = findProjectById(projectId);
	        if (existingProject == null) {
	            throw new RuntimeException("ProjectNotFoundException: Project not found with ID: " + projectId);
	        }

	            existingProject.setTitle(updatedProject.getTitle());
	            existingProject.setTasks(updatedProject.getTasks());
	        
	    }

	    public List<Project> getAllProjects() {
	        return projects;
	    }
	    
	    // Helper method to find a project by ID
	    private Project findProjectById(Long projectId) {
	        for (Project project : projects) {
	            if (project.getId().equals(projectId)) {
	                return project;
	            }
	        }
	        return null;
	    }
	    
	    private boolean isDuplicateProjectName(String title) {
	        for (Project project : projects) {
	            if (project.getTitle().equals(title)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    private boolean hasInProgressTasks(List<Task> tasks) {
	        for (Task task : tasks) {
	            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
	                return true;
	            }
	        }
	        return false;
	    }
	    private boolean isMoreThanSixMonths(LocalDateTime createdDate) {
	        LocalDateTime currentDate = LocalDateTime.now();
	        return createdDate.plusMonths(6).isBefore(currentDate);
	    }
}
