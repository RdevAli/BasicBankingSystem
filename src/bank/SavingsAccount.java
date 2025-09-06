package bank;

public class SavingsAccount extends Account {

    private double interestRate;  // e.g. 0.03 = 3%

    public SavingsAccount(String accountNumber, String ownerName, double openingBalance, double interestRate) {
        super(accountNumber, ownerName, openingBalance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate must be non-negative");
        }
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds in Savings Account");
        }
        setBalance(getBalance() - amount);
    }
}
