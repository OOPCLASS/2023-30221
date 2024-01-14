import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an array of students
        Student[] students = {
                new Student("Alice", 85),
                new Student("Bob", 75),
                new Student("Charlie", 90)
        };

        // Create an instance of ComparableObjectsSorter
        ComparableObjectsSorter<Student> studentSorter = new ComparableObjectsSorter<>();

        // Sort the array of students
        studentSorter.sort(students);

        // Display the sorted students
        System.out.println("Sorted Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Example usage of FileStorageService
        StorageService<Student> fileStudentStorage = new FileStorageService<>("students.dat");

        // Write data to the file
        fileStudentStorage.writeData(Arrays.asList(students));

        // Read data from the file
        List<Student> studentsFromFile = fileStudentStorage.readData();
        System.out.println("\nStudents from File:");
        studentsFromFile.forEach(System.out::println);

        // Example usage of InMemoryStorageService
        StorageService<Student> inMemoryStudentStorage = new InMemoryStorageService<>();

        // Write data to the in-memory list
        inMemoryStudentStorage.writeData(Arrays.asList(students));

        // Read data from the in-memory list
        List<Student> studentsFromMemory = inMemoryStudentStorage.readData();
        System.out.println("\nStudents from In-Memory Storage:");
        studentsFromMemory.forEach(System.out::println);

    }
}
