package banks;

public class CheckingAccount {

    //TODO : (1) Data Fields
    private String name;
    private int age;
    private int routingNumber;
    private int accountNumber;

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
