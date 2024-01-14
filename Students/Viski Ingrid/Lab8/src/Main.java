import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ObjectSorter sorter = new ObjectSorter();

        Teacher teacher1 = new Teacher("John", 20);
        Teacher teacher2 = new Teacher("Alice", 15);
        Teacher teacher3 = new Teacher("Bob", 20);

        Teacher[] teachers = {teacher1, teacher2, teacher3};
        Comparable[] sortedTeachersAsc = sorter.sort(teachers, true);
        Comparable[] sortedTeachersDesc = sorter.sort(teachers, false);

        System.out.println("Teachers (Original): " + Arrays.toString(teachers));
        System.out.println("Teachers (Ascending): " + Arrays.toString(sortedTeachersAsc));
        System.out.println("Teachers (Descending): " + Arrays.toString(sortedTeachersDesc));

        System.out.println("\n");

        Student student1 = new Student("Tom", 8.5);
        Student student2 = new Student("Mary", 9.0);
        Student student3 = new Student("David", 5.5);

        Student[] students = {student1, student2, student3};
        Comparable[] sortedStudentsAsc = sorter.sort(students, true);
        Comparable[] sortedStudentsDesc = sorter.sort(students, false);

        System.out.println("Students (Original): " + Arrays.toString(students));
        System.out.println("Students (Ascending): " + Arrays.toString(sortedStudentsAsc));
        System.out.println("Students (Descending): " + Arrays.toString(sortedStudentsDesc));
    }
}