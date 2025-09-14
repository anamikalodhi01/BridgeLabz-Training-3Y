import java.util.ArrayList;

// Abstract class for Bank Account
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    // Getters and setters (Encapsulation)
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}

// Interface for loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    void calculateLoanEligibility();
}

// Savings Account subclass
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public void calculateLoanEligibility() {
        double eligibleAmount = getBalance() * 2;
        System.out.println("Loan Eligibility: " + eligibleAmount);
    }
}

// Current Account subclass
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for current account
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public void calculateLoanEligibility() {
        double eligibleAmount = getBalance() * 1.5;
        System.out.println("Loan Eligibility: " + eligibleAmount);
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savings = new SavingsAccount("SA101", "Alice", 50000);
        CurrentAccount current = new CurrentAccount("CA202", "Bob", 30000);

        accounts.add(savings);
        accounts.add(current);

        // Polymorphism: Process all accounts
        for (BankAccount acc : accounts) {
            acc.displayDetails();
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable loanable) {
                loanable.calculateLoanEligibility();
                loanable.applyForLoan(20000);
            }

            System.out.println("---------------------------");
        }

        // Example transactions
        savings.deposit(5000);
        current.withdraw(10000);
    }
}
