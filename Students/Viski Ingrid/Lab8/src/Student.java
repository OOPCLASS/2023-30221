public class Student extends Person implements Identifiable, AddressAware {

    private Double grade;

    public Student(String name, Double grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public void setAddress(String address) {

    }

    @Override
    public String getRole() {
        return null;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof Student) {
            Student otherStudent = (Student) object;
            int gradeComparison = Double.compare(this.grade, otherStudent.grade);
            if (gradeComparison != 0) {
                return gradeComparison;
            }
            return this.getName().compareTo(otherStudent.getName());
        }
        return 0;
    }

    public String toString() {
        return getName();
    }
}