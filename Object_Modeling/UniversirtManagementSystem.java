import java.util.ArrayList;

// Student class
class Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>(); // Association: student enrolls in courses

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // Link student to course
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getName() { return name; }
}

// Professor class
class UniversirtManagementSystem {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>(); // Association: professor teaches courses

    public UniversirtManagementSystem(String name) {
        this.name = name;
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.setProfessor(this); // Link professor to course
        System.out.println(name + " assigned to teach " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("Courses taught by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getName() { return name; }
}

// Course class
class Course {
    private String courseName;
    private UniversirtManagementSystem professor;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void setProfessor(UniversirtManagementSystem professor) {
        this.professor = professor;
    }

    public void showStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }

    public String getCourseName() { return courseName; }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create professors
        UniversirtManagementSystem p1 = new UniversirtManagementSystem("Dr. Smith");
        UniversirtManagementSystem p2 = new UniversirtManagementSystem("Dr. Johnson");

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        // Assign professors to courses
        p1.assignCourse(c1);
        p2.assignCourse(c2);

        // Students enroll in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // Display information
        s1.showCourses();
        s2.showCourses();

        p1.showCourses();
        p2.showCourses();

        c1.showStudents();
        c2.showStudents();
    }
}
