package CarRental;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car1 = new Car("C01", "Ford", "Mustang", 90.0,true);
        Car car2 = new Car("C02", "BMW", "X5", 120.0,true);
        Car car3 = new Car("C03", "Audi", "A4", 100.0,true);
        Car car4 = new Car("C04", "Mercedes-Benz", "E-Class", 110.0,true);
        Car car5 = new Car("C05", "Volvo", "XC90", 130.0,true);
        Car car6 = new Car("C06", "Lexus", "RX", 140.0,true);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);


        rentalSystem.menu();



    }
    }

