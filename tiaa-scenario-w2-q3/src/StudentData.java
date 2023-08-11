import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    int age;
    String courseName;
    Date dateOfEnrollment;

    public Student(String name, int age, String courseName, Date dateOfEnrollment) {
        this.name = name;
        this.age = age;
        this.courseName = courseName;
        this.dateOfEnrollment = dateOfEnrollment;
    }
    
    public int getAge() {
    	return age;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }
}

public class StudentData {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Add student data to the collection
        students.add(new Student("Alice", 20, "Java", new Date()));
        students.add(new Student("Bob", 22, "Python", new Date()));
        students.add(new Student("Charlie", 19, "Java", new Date()));
        students.add(new Student("David", 21, "Python", new Date()));

        // 1. List student data sorted by name
        List<Student> sortedByName = students.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());

        System.out.println("Students sorted by name:");
        sortedByName.forEach(student -> System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getCourseName() + ", " + student.dateOfEnrollment));

        // 2. Search students who enrolled for Java course
        List<Student> javaEnrolledStudents = students.stream()
                .filter(student -> student.getCourseName().equals("Java"))
                .collect(Collectors.toList());

        System.out.println("\nStudents enrolled for Java course:");
        javaEnrolledStudents.forEach(student -> System.out.println(student.getName() + ", " + student.getAge() + ", " + student.dateOfEnrollment));

        // 3. Count number of students who enrolled for Python course
        long pythonEnrolledCount = students.stream()
                .filter(student -> student.getCourseName().equals("Python"))
                .count();

        System.out.println("\nNumber of students enrolled for Python course: " + pythonEnrolledCount);
    }
}