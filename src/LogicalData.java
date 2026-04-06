import java.util.*;

public class LogicalData {
    public LinkedList<bankAccount> accounts = new LinkedList<>();
    public Stack<String> transactionHistory = new Stack<>();
    public Queue<String> billQueue = new LinkedList<>();
    public Queue<bankAccount> accountRequests = new LinkedList<>();

    public bankAccount findAccount(String name){
        for(bankAccount acc : accounts){
            if(acc.username.equalsIgnoreCase(name)) return acc;
        }
        return null;
    }
}
