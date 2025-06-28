public class BankAccount {
    // Private fields (data hiding)
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Public getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money (with validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to withdraw money (with validation)
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);

        // Cannot directly access balance (it's private)
        // account.balance = 5000; // ❌ Compilation error

        // Use public methods to interact
        account.deposit(500);
        account.withdraw(200);

        System.out.println("Account Balance: $" + account.getBalance());
    }
}

/*
 * Output:
 * Account Balance: $1300.0
 */