package CarRental;

public class Car {
    private String carID;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean isAvailable;

    public Car (String carID,String brand,String model,double pricePerDay, boolean isAvailable){
        this.carID=carID;
        this.brand=brand;
        this.model=model;
        this.isAvailable=true;
        this.pricePerDay=pricePerDay;
    }

    public  void setCarID(String carID){
        this.carID=carID;
    }
    public String getCarId() {
        return carID;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double calculatePrice(int rentalDays) {
        return pricePerDay * rentalDays;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }


}
