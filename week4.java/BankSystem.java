// File: BankSystem.java

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    // Getter and Setter
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MIN_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied: balance cannot fall below " + MIN_BALANCE);
        }
    }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        System.out.println("Interest added: " + interest);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        // Create a SavingsAccount
        SavingsAccount myAccount = new SavingsAccount("ACC12345", 2000.0, 5.0);

        // Display initial balance
        System.out.println("Initial Balance: " + myAccount.getBalance());

        // Deposit money
        myAccount.deposit(500);

        // Add interest
        myAccount.addInterest();

        // Try withdrawing within allowed limit
        myAccount.withdraw(1000);

        // Try withdrawing below minimum balance
        myAccount.withdraw(1200);

        // Final balance
        System.out.println("Final Balance: " + myAccount.getBalance());
    }
}

