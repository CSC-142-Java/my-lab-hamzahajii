package banks;

public class CheckingAccount {

    //TODO : (1) Data Fields
    private String name;
    private int age;
    private int routingNumber;
    private int accountNumber;

    //TODO: (5) create default constructor and initialize parameters
    public CheckingAccount(){
        this("Unknown", 18, 110, 10000);
    }


    //TODO: (4) create a constructor with all the parameters
    public CheckingAccount(String name, int age, int routingNumber, int accountNumber) {
        this.name = name;
        this.age = age;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    //TODO: (2) We created gettor/accessor methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    //TODO: (3) Create "settor" methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
