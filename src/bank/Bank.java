package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Bank {


    private final String bankName;
    private List<Account> accounts = new ArrayList<>();

    // --- Constructor ---
    public Bank(String bankName) {
        if (bankName == null || bankName.isBlank()) {
            throw new IllegalArgumentException("Bank name cannot be empty");
        }
        this.bankName = bankName;
    }


    public String getBankName() { return bankName; }
    public final List<Account> getAccounts() { return accounts; } // read-only use recommended


    public void openAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        // Ensure uniqueness by accountNumber
        if (findAccountOrNull(account.getAccountNumber()) != null) {
            throw new IllegalArgumentException("Account number already exists: " + account.getAccountNumber());
        }
        accounts.add(account);
    }

    public boolean closeAccount(String accountNumber) {
        return accounts.removeIf(a -> a.getAccountNumber().equals(accountNumber));
    }

    public Account findAccount(String accountNumber) {
        Account acc = findAccountOrNull(accountNumber);
        if (acc == null) {
            throw new NoSuchElementException("No account found with number: " + accountNumber);
        }
        return acc;
    }

    // Convenience methods that route to the right account
    public void deposit(String accountNumber, double amount) {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        findAccount(accountNumber).withdraw(amount); // polymorphic: runs the right rule
    }

    // --- Helper ---
    private Account findAccountOrNull(String accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) return a;
        }
        return null;
    }
}
