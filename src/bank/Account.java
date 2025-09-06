package bank;

public abstract class Account {

    // encapsulated attributes
    private String accountNumber;
    private String ownerName;
    private double balance;



    public Account(String accountNumber, String ownerName, double openingBalance){
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening Balance must be Positive");
        }
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        this.balance=openingBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount) {
        if (amount<=0){
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        else{
            balance+=amount;
        }

    }
    public abstract void withdraw(double amount);
    protected void setBalance(double newBalance){
        this.balance=newBalance;
    }
}