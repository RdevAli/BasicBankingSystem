package bank;

public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank myBank = new Bank("MyBank");

        // Open accounts
        SavingsAccount savings = new SavingsAccount("001", "Alice", 1000.0, 0.03);
        CurrentAccount current = new CurrentAccount("002", "Bob", 500.0, 200.0);

        myBank.openAccount(savings);
        myBank.openAccount(current);

        // Show balances
        System.out.println("Initial Balances:");
        System.out.println("Alice (Savings): " + savings.getBalance());
        System.out.println("Bob (Current): " + current.getBalance());

        // Deposit
        myBank.deposit("001", 200.0); // deposit into Alice’s savings
        myBank.deposit("002", 300.0); // deposit into Bob’s current

        // Withdraw
        myBank.withdraw("001", 100.0); // Savings: must have enough funds
        myBank.withdraw("002", 600.0); // Current: allowed, balance + overdraft covers it

        // Apply interest
        savings.applyInterest();

        // Final balances
        System.out.println("\nAfter transactions:");
        System.out.println("Alice (Savings): " + savings.getBalance());
        System.out.println("Bob (Current): " + current.getBalance());
    }
}
