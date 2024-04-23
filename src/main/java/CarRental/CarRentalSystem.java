package CarRental;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));

        } else {
            System.out.println("Makina nuk eshte e lire per t'u marre me qira");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Makina nuk u mor me qira.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Car Rental System ----");
            System.out.println("1. Merr me qira nje makine");
            System.out.println("2. Kthe makinen");
            System.out.println("3. Dil");
            System.out.print("Vendos zgjedhjen tende: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n--Merr me qira nje makine --\n");
                System.out.print("Vendosni emrin tuaj: ");
                String customerName = scanner.nextLine();

                System.out.println("\nMakina te lira:");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }

                System.out.print("\nVendos ID e makines qe do te marresh me qira: ");
                String carId = scanner.nextLine();

                System.out.print("Vendos numrin e diteve qe do te marresh makinen me qira: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer(1 + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n--- Rental Information ----\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerID());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nKonfirmo (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nMakina u mor me qira me sukses.");
                    } else {
                        System.out.println("\nQiraja e makines nuk u krye.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n--- Return a Car ---\n");
                System.out.print("Vendos ID  e makines qe do te dorezoni: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                    }

                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Makina u kthye me sukses nga  " + customer.getName());
                        } else {
                            System.out.println("Makina nuk u kthye .");
                        }
                    } else {
                        System.out.println("Ndodhi nje problem ose invalid ID .");
                    }
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Te lutem zgjidhni nje opsion tjeter");
                }
            }

            System.out.println("\nThank you for using the Car Rental System!");
        }
    }


