import java.util.Scanner;

public class bankApp {
    private static LogicalData logical = new LogicalData();
    private static PhysicalData physical = new PhysicalData();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        physical.demonstrateArray();

        while(true){
            System.out.println("\n1-Bank | 2-ATM | 3-Admin | 4-Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
            }
        }
    }

    private static void bankMenu(){
        System.out.println("1. Open Account Request");
        System.out.println("2. Open a Bill Payment");
        int op = sc.nextInt();
        sc.nextLine();
        if(op == 1){
            System.out.print("Name: ");
            String n = sc.nextLine();
            logical.accountRequests.add(new bankAccount("TEMP", n, 0));
        }
        else{
            System.out.print("Bill type: ");
            logical.billQueue.add(sc.nextLine());
        }
    }

    private static void atmMenu(){
        System.out.println("Username: ");
        bankAccount acc = logical.findAccount(sc.nextLine());
        if(acc != null){
            System.out.println("Balance: " + acc.balance);
        }
        else{
            System.out.println("Account not found in List");
        }
    }

    private static void adminMenu(){
        System.out.println("1. Process new Account| 2. Process Bill");
        int op = sc.nextInt();
        sc.nextLine();
        if(op == 1 && !logical.accountRequests.isEmpty()){
            logical.accounts.add(logical.accountRequests.poll());
            System.out.println("Account activated");
        }
        else if(op == 2 && !logical.billQueue.isEmpty()){
            System.out.println("Processing: " + logical.billQueue.poll());
        }
    }
}