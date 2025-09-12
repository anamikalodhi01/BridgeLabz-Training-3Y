// Base class
class Book {
    public String ISBN;         // public
    protected String title;     // protected
    private String author;      // private

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public methods for private author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
    }
}

// Subclass
class EBook extends Book {
    double fileSizeMB;

    EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    void showDetails() {
        // can access ISBN (public) and title (protected)
        System.out.println("EBook ISBN: " + ISBN + ", Title: " + title + ", File Size: " + fileSizeMB + "MB");
    }
}
