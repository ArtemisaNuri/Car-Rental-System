package CarRental;

public class Customer {

    private  int customerID;
    private  String  name;

    public  Customer (int customerID, String name){
        this.customerID= customerID;
        this.name= name;

    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

