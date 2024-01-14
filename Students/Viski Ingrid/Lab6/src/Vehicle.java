public class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private double rentalRate;
    private boolean isRented;

    public Vehicle() {

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void rent() {
        if(!isRented) {
            isRented = true;
            System.out.println("Rented");
        }
        else {
            System.out.println("Vehicle is already rented");
        }
    }
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Returned");
        }
        else {
            System.out.println("Vehicle is not currently rented");
        }
    }

    double calculateRentalCost(int days) {
        if (days < 0) {
            System.out.println("Invalid number of days");
            return -1;
        }
        return rentalRate * days;
    }
}
