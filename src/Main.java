public class Main {
    public static void main(String[] args){
        BankingSystem system = new BankingSystem();

        BankAccount[] initialArray = new BankAccount[3];
        initialArray[0] = new BankAccount("101", "Ali", 15000);
        initialArray[1] = new BankAccount("102", "Sara", 22000);
        initialArray[2] = new BankAccount("103", "Phill", 29000);

        for(BankAccount acc : initialArray){
            system.addAccountDirectly(acc);
        }

        MenuHandler menu = new MenuHandler(system);
        menu.showMainMenu();
    }
}
