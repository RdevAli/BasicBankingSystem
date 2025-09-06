package bank;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String ownerName, double openingBalance, double overdraftLimit) {
        super(accountNumber, ownerName, openingBalance);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit must be non-negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        double available = getBalance() + overdraftLimit;
        if (amount > available) {
            throw new IllegalArgumentException("Withdrawal exceeds overdraft limit");
        }
        setBalance(getBalance() - amount);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
