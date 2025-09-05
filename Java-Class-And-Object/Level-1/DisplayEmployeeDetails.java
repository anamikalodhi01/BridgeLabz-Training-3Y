class DisplayEmployeeDetails {
    String name;
    int id;
    double salary;

    DisplayEmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        DisplayEmployeeDetails e1 = new DisplayEmployeeDetails("Anamika", 101, 50000);
        e1.displayDetails();
    }
}
