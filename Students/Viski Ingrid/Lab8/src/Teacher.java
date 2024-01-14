public class Teacher extends Person {

    private int numberOfStudents;

    public Teacher(String name, int numberOfStudents) {
        super(name);
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    @Override
    public String getRole() {
        return "teacher";
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof Teacher) {
            Teacher otherTeacher = (Teacher)object;
            int result = Integer.compare(this.numberOfStudents, otherTeacher.numberOfStudents);
            if (result == 0) {
                result = this.getName().compareTo(otherTeacher.getName());
            }
            return result;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getName();
    }
}