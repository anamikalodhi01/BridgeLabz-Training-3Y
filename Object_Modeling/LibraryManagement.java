import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Library class
class Library {
    private String name;
    private ArrayList<Book> books = new ArrayList<>(); // Aggregation: library has books

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
    }
}

// Main class
public class LibraryManagement {
    public static void main(String[] args) {
        // Create books (independent of any library)
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Alchemist", "Paulo Coelho");

        // Create libraries
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("Community Library");

        // Add books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // Same book can exist in multiple libraries
        lib2.addBook(b3);

        // Display books in each library
        lib1.showBooks();
        lib2.showBooks();
    }
}
