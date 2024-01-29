package pack;

import java.util.HashMap;
import java.util.Map;


import pack.DuplicateProjectNameException;
import pack.ProjectNotFoundException;

class ProjectService {
    private Map<Integer, Project> projects = new HashMap<>();

    public void createProject(int projectId, String projectName) {
        if (projects.values().stream().anyMatch(project -> project.getName().equals(projectName))) {
            throw new DuplicateProjectNameException("Duplicate project name: " + projectName);
        }
        projects.put(projectId, new Project(projectId, projectName));
    }

    public Project getProject(int projectId) {
        if (!projects.containsKey(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
        return projects.get(projectId);
    }

    public void updateProject(int projectId, String newName) {
        if (!projects.containsKey(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
        projects.get(projectId).setName(newName);
    }

    public boolean deleteProject(int projectId) {
        if (!projects.containsKey(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }

        Project project = projects.get(projectId);

        if (project.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS)) {
            if (System.currentTimeMillis() - project.getCreationDate() <= 6 * 30 * 24 * 60 * 60 * 1000) {
                return false;
            }
        }

        projects.remove(projectId);
        return true;
    }
}