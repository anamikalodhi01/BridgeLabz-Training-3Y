
class BankAccount {
    // Static variable shared across all accounts
    static String bankName = "National Bank";
    
    // Static counter to track total accounts
    private static int totalAccounts = 0;
    
    // Final variable - account number cannot be changed once assigned
    private final int accountNumber;
    
    // Instance variable
    private String accountHolderName;
    private double balance;
    
    // Constructor using 'this' to resolve ambiguity
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++; // Increment count for each new account
    }
    
    // Static method to display total number of accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts in " + bankName + ": " + totalAccounts);
    }
    
    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Bank: " + bankName);
        System.out.println("-----------------------------");
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        // Create accounts
        BankAccount acc1 = new BankAccount(1001, "Alice", 50000);
        BankAccount acc2 = new BankAccount(1002, "Bob", 35000);
        
        // Use instanceof before displaying details
        if (acc1 instanceof BankAccount) {
            acc1.displayAccountDetails();
        }
        
        if (acc2 instanceof BankAccount) {
            acc2.displayAccountDetails();
        }
        
        // Show total accounts
        BankAccount.getTotalAccounts();
    }
}
