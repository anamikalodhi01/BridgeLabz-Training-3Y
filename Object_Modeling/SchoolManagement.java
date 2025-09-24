import java.util.ArrayList;

// Student class
class Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    // Association: enroll in a course
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // Add student to course's student list
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getName() { return name; }
}

// Course class
class Course {
    private String courseName;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    // Association: add student to course
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void showStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }

    public String getCourseName() { return courseName; }
}

// School class
class School {
    private String name;
    private ArrayList<Student> students = new ArrayList<>(); // Aggregation: school has students

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}

// Main class
public class SchoolManagement {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        // Students enroll in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // Create school and add students (aggregation)
        School school = new School("Greenwood High");
        school.addStudent(s1);
        school.addStudent(s2);

        // Display information
        school.showStudents();
        s1.showCourses();
        s2.showCourses();
        c1.showStudents();
        c2.showStudents();
    }
}
