class HandleBookDetails {
    String title;
    String author;
    double price;

    HandleBookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        HandleBookDetails b1 = new HandleBookDetails("Java Programming", "James Gosling", 450.50);
        b1.displayDetails();
    }
}
