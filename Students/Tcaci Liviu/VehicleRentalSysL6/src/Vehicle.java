public class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private double rentalRate;
    private boolean isRented;

    public Vehicle(String registrationNumber, String make, String model, int year, double rentalRate) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
        this.isRented = false;
    }

    public boolean rent() {
        if (!isRented) {
            isRented = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnVehicle() {
        if (isRented) {
            isRented = false;
            return true;
        } else {
            return false;
        }
    }

    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    // Getters and setters (if needed)...

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isRented() {
        return isRented;
    }
}
