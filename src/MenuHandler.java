import java.util.Scanner;

public class MenuHandler {
    private BankingSystem system;
    private Scanner scanner = new Scanner(System.in);

    public MenuHandler(BankingSystem system) {
        this.system = system;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("1 - Select Bank");
            System.out.println("2 - Select ATM");
            System.out.println("3 - Select Admin Account");
            System.out.println("4 - Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void bankMenu() {
        System.out.println("Bank Menu");
        System.out.println("1. Submit Account Request");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Undo Transaction");
        System.out.println("5. Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter name: ");
                system.requestNewAccount(scanner.next());
                System.out.println("Request added to queue.");
            }
            case 2, 3 -> {
                System.out.print("Username: ");
                BankAccount acc = system.findAccount(scanner.next());
                if (acc == null){
                    System.out.println("Not found."); return;
                }
                System.out.print("Amount: ");
                double amt = scanner.nextDouble();
                if (choice == 2){
                    system.deposit(acc, amt);
                }
                else{
                    system.withdraw(acc, amt);
                }
            }
            case 4 -> system.undoLastTransaction();
        }
    }

    private void atmMenu() {
        System.out.print("Insert card (Enter username): ");
        BankAccount acc = system.findAccount(scanner.next());
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Last Transaction");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> System.out.println("Balance: " + acc.balance); // [cite: 86]
            case 2 -> {
                System.out.print("Amount: ");
                system.withdraw(acc, scanner.nextDouble());
            }
            case 3 -> system.showLastTransaction();
        }
    }

    private void adminMenu() {
        System.out.println("Admin Area");
        System.out.println("1. Process Account Queue");
        System.out.println("2. Process Bill Queue");
        System.out.println("3. Display All Accounts");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                if (!system.getAccountRequests().isEmpty()) {
                    BankAccount newAcc = system.getAccountRequests().poll();
                    system.addAccountDirectly(newAcc);
                    System.out.println("Account created for " + newAcc.username);
                }
                else {
                    System.out.println("No pending requests.");
                }
            }
            case 2 -> {
                if (!system.getBillQueue().isEmpty()) {
                    System.out.println("Processing: " + system.getBillQueue().poll());
                }
                else{
                    System.out.println("No bills in queue.");
                }
            }
            case 3 -> system.getAccounts().forEach(System.out::println);
        }
    }
}