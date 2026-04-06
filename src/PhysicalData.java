public class PhysicalData {
    public void demonstrateArray(){
        bankAccount[] physicalStorage = new bankAccount[3];

        physicalStorage[0] = new bankAccount("P0001", "Ali", 15000);
        physicalStorage[1] = new bankAccount("P0002", "Sara", 22000);
        physicalStorage[2] = new bankAccount("P0003", "Denis", 29000);

        System.out.println("Physical Structure Output");
        for(bankAccount acc : physicalStorage){
            System.out.println(acc);
        }
    }
}