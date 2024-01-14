public class Teacher implements Comparable<Teacher> {
    private String name;
    private int numberOfStudents;

    public Teacher(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    @Override
    public int compareTo(Teacher other) {
        if (this.numberOfStudents != other.numberOfStudents) {
            return Integer.compare(this.numberOfStudents, other.numberOfStudents);
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
