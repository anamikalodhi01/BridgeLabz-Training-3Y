class Course {
    // Instance variables
    String courseName;
    int duration; // in months
    double fee;

    // Class variable
    static String instituteName = "Default Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course: " + courseName + 
                           ", Duration: " + duration + " months" + 
                           ", Fee: " + fee + 
                           ", Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String name) {
        instituteName = name;
        System.out.println("Institute name updated to: " + instituteName);
    }
}
