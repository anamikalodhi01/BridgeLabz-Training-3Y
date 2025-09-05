class AreaOfCircle {
    double radius;

    AreaOfCircle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double circumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
        System.out.println("Circumference: " + circumference());
    }

    public static void main(String[] args) {
        AreaOfCircle c1 = new AreaOfCircle(7);
        c1.display();
    }
}
