package demo;

import java.util.Objects;

// Clasa Task extinde AbstractEntity
// Pt fiecare task in parteare metode specifice, in principal de bazeaza pe status.
public class Task extends AbstractEntity<Long> {
    private String title;
    private TaskStatus status;

    public Task(String title, TaskStatus status) {
        this.title = title;
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){return title;}

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus(){return status;}

    @Override
    public Long getId() {
        return super.getId();
    }

    // Metoda este folosita pt a verifica daca 2 obiecte sunt egale
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
