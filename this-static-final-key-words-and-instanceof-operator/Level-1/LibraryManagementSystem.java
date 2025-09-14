
class Book {
    // Static variable shared by all books
    static String libraryName = "Central City Library";
    
    // Final variable - ISBN cannot be changed once assigned
    private final String isbn;
    
    // Instance variables
    private String title;
    private String author;
    
    // Constructor using 'this'
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Library: " + libraryName);
        System.out.println("-----------------------------");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create book objects
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");
        
        // Verify using instanceof before displaying details
        if (b1 instanceof Book) {
            b1.displayBookDetails();
        }
        
        if (b2 instanceof Book) {
            b2.displayBookDetails();
        }
        
        // Display library name
        Book.displayLibraryName();
    }
}
