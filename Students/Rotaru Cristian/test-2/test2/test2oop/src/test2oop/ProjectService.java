package test2oop;

import test2oop.exceptions.DuplicateProjectNameException;
import test2oop.exceptions.ProjectNotFoundException;

import java.util.Calendar;
import java.util.List;

public class ProjectService {

    private List<Project<Long>> projects;

    public ProjectService() {
    }
    public ProjectService(List<Project<Long>> projects) {
        this.projects = projects;
    }

    public List<Project<Long>> getProjects() {
        return projects;
    }

    public void setProjects(List<Project<Long>> projects) {
        this.projects = projects;
    }

    public Project<Long> create(String title) {
        Long id = null;
        for (Project<Long> project : projects) {
            if (title.equals(project.getTitle())) {
                throw new DuplicateProjectNameException("Project with title " + title + " already exists");
            }
        }

        Project<Long> project = new Project<Long>(id, title, null);
        projects.add(project);

        return project;

    }

    public boolean delete(Project<Long> project) {
        if (project == null) {
            throw new ProjectNotFoundException("Project not found");
        }

        for (Task<Long> tasks : project.getTasks()) {
            if (tasks.getStatus() == TaskStatus.IN_PROGRESS) {
                return false;
            }
        }

        Calendar projectStartDate = Calendar.getInstance();
        projectStartDate.setTime(project.getStartDate());

        Calendar currentDate = Calendar.getInstance();

        projectStartDate.add(Calendar.MONTH, 6);

        if (currentDate.after(projectStartDate)) {
            projects.remove(project);
            return true;
        }

        projects.remove(project);
        return true;
    }

    public Project<Long> get(Long id) {
        for (Project<Long> project : projects) {
            if (id.equals(project.getId())) {
                return project;
            }
        }
        throw new ProjectNotFoundException("Project with id " + id + " not found");
    }

    public Project<Long> update(Long id, Project<Long> project) {
        for (Project<Long> p : projects) {
            if (id.equals(p.getId())) {
                p.setTitle(project.getTitle());
                return p;
            }
        }
        throw new ProjectNotFoundException("Project with id " + id + " not found");
    }

}
