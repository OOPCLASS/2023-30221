public abstract class Person implements Comparable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Role: " + getRole());
    }

    public abstract String getRole();
}