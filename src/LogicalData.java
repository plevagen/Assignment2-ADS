import java.util.*;

public class LogicalData {
    public LinkedList<BankAccount> accounts = new LinkedList<>();
    public Stack<String> transactionHistory = new Stack<>();
    public Queue<String> billQueue = new LinkedList<>();
    public Queue<BankAccount> accountRequests = new LinkedList<>();

    public BankAccount findAccount(String name){
        for(BankAccount acc : accounts){
            if(acc.username.equalsIgnoreCase(name)) return acc;
        }
        return null;
    }
}
