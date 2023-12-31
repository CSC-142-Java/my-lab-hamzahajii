package banks;

public class BankingProgram {

    public static void print(CheckingAccount account) {
        System.out.println("***********************");
        System.out.println("Name: " + account.getName());
        System.out.println("Age: " + account.getAge());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Routing Number: " + account.getRoutingNumber());
        System.out.println("***********************");
    }

    public static void main(String[] args) {
        CheckingAccount john = new CheckingAccount("John Lewis", 19, 113, 30752);
        john.setName("John Lewis");
        john.setAge(19);
        john.setAccountNumber(30752);
        john.setRoutingNumber(113);
        print(john);

        CheckingAccount samantha = new CheckingAccount("Samantha Barks", 21, 113, 17359);
        samantha.setName("Samantha Barks");
        samantha.setAge(21);
        samantha.setAccountNumber(17359);
        samantha.setRoutingNumber(113);
        print(samantha);


        CheckingAccount unknown = new CheckingAccount();
        print(unknown);
    }
}
