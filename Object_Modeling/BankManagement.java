import java.util.ArrayList;

// Customer class
class Customer {
    private String name;
    private double balance;
    private Bank bank; // Association: linked to a bank

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Link customer to a bank (association)
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void viewBalance() {
        System.out.println(name + "'s balance in " + (bank != null ? bank.getName() : "No Bank") + ": $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public String getName() { return name; }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
        customer.setBank(this); // Associate customer with this bank
        System.out.println("Account opened for " + customer.getName() + " at " + name);
    }

    public void showCustomers() {
        System.out.println("Customers of " + name + ":");
        for (Customer c : customers) {
            System.out.println(c.getName());
        }
    }

    public String getName() { return name; }
}

// Main class
public class BankManagement {
    public static void main(String[] args) {
        // Create bank
        Bank bank1 = new Bank("City Bank");

        // Create customers
        Customer c1 = new Customer("Alice", 1000);
        Customer c2 = new Customer("Bob", 500);

        // Open accounts in bank
        bank1.openAccount(c1);
        bank1.openAccount(c2);

        // Show customer details and balances
        bank1.showCustomers();
        c1.viewBalance();
        c2.viewBalance();

        // Transactions
        c1.deposit(200);
        c2.withdraw(100);
    }
}
