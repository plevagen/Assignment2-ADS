import java.util.*;

public class BankingSystem{
    private LinkedList<BankAccount> accounts = new LinkedList<>();
    private Stack<String> transactionHistory = new Stack<>();
    private Queue<String> billQueue = new LinkedList<>();
    private Queue<BankAccount> accountRequests = new LinkedList<>();

    public void addAccountDirectly(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String name) {
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)){
                return acc;
            }
        }
        return null;
    }
    public void deposit(BankAccount acc, double amount) {
        acc.balance += amount;
        transactionHistory.push("Deposit " + amount + " to " + acc.username);
    }

    public boolean withdraw(BankAccount acc, double amount) {
        if (acc.balance >= amount) {
            acc.balance -= amount;
            transactionHistory.push("Withdraw " + amount + " from " + acc.username);
            return true;
        }
        return false;
    }

    public void undoLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            System.out.println("Undo → " + transactionHistory.pop() + " removed");
        }
        else{
            System.out.println("No transactions to undo.");
        }
    }

    public void showLastTransaction() {
        if (!transactionHistory.isEmpty()){
            System.out.println("Last transaction: " + transactionHistory.peek());
        }
    }

    public void requestNewAccount(String name) {
        String id = "ACC" + (accounts.size() + accountRequests.size() + 1);
        accountRequests.add(new BankAccount(id, name, 0));
    }

    public void addBill(String billName) {
        billQueue.add(billName);
    }

    public LinkedList<BankAccount> getAccounts() { return accounts; }
    public Queue<BankAccount> getAccountRequests() { return accountRequests; }
    public Queue<String> getBillQueue() { return billQueue; }
}