import java.util.ArrayList;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }

    // Encapsulation: Getters and Setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    void checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
            System.out.println("Book reserved by: " + borrowerName);
        } else {
            System.out.println("Book is already reserved by: " + borrower);
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("Book availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
            System.out.println("Magazine reserved by: " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved by: " + borrower);
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("Magazine availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
            System.out.println("DVD reserved by: " + borrowerName);
        } else {
            System.out.println("DVD is already reserved by: " + borrower);
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("DVD availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();

        Book book = new Book("B001", "Java Programming", "Alice");
        Magazine magazine = new Magazine("M001", "Tech Monthly", "Bob");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan");

        items.add(book);
        items.add(magazine);
        items.add(dvd);

        // Polymorphism: Manage all items
        for (LibraryItem item : items) {
            item.getItemDetails();

            if (item instanceof Reservable reservable) {
                reservable.checkAvailability();
                reservable.reserveItem("John Doe");
                reservable.checkAvailability();
            }

            System.out.println("---------------------------");
        }
    }
}
