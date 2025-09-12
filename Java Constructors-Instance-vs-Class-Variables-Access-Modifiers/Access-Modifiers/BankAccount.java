// Base class
class BankAccount {
    public String accountNumber;   // public
    protected String accountHolder; // protected
    private double balance;        // private

    // Constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public methods to access private balance
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }
}

// Subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void showDetails() {
        // can access accountNumber (public) and accountHolder (protected)
        System.out.println("Savings Account - Number: " + accountNumber + ", Holder: " + accountHolder + ", Interest Rate: " + interestRate + "%");
    }
}
