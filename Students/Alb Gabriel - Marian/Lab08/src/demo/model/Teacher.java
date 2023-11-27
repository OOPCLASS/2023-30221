package demo.model;

public class Teacher extends Person {

    private int numberOfStudents;

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "teacher";
    }

    @Override
    public int compareTo(Object object) {
        // your code here
        // compare by number of students in descending order
        if(object instanceof Teacher){
            int result = Integer.compare((((Teacher) object).numberOfStudents), this.numberOfStudents);
            if(result == 0){
                // now compare by name if nr of students is equal
                result = (((Teacher) object).getName()).compareTo(this.getName());
            }
            return result;
        }
        return 0;
    }
}
