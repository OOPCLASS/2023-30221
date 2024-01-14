package demo.model;

import demo.AddressAware;
import demo.Identifiable;
import demo.ObjectSorter;

import java.util.Objects;

public class Student extends Person implements Identifiable, AddressAware {
    private String id;
    private String address;
    private Double grade;

    public Student(String name) {
        super(name);
    }

    public Student(Double grade) {
        super("student");
        this.grade = grade;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getRole() {
        return "student";
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Object object) {
        // your code here
        if(object instanceof Student){
            int result = Double.compare(((Student) object).getGrade(), this.getGrade());
            if(result == 0){
                // now compare by name if grades are equal
                result = (((Student) object).getName()).compareTo(this.getName());
            }
            return result;
        }
        return 0;
    }
}