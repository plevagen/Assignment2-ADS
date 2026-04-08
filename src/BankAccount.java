public class BankAccount {
    String accountNumber;
    String username;
    int balance;

    public BankAccount(String accountNumber, String username, int balance){
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "User: " + username + "| Acc: " + accountNumber + "| Balance: " + balance;
    }
}