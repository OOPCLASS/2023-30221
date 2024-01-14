import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        if (this.grade != other.grade) {
            return Integer.compare(this.grade, other.grade);
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    // Implementing Serializable interface
    private static final long serialVersionUID = 1L; // Include this to avoid warnings
}
