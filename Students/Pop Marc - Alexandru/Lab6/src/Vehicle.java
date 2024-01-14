public class Vehicle {
    private String registrationNumber;

    private String make;

    private String model;

    private int year;

    private double rentalRate;

    protected Vehicle(String registrationNumber, String make, String model, int year, double rentalRate) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void rent() {
        System.out.println("Vehicle with registration number " + registrationNumber + " rented!");
    }

    public void returnVehicle() {
        System.out.println("Vehicle with registration number " + registrationNumber + " returned!");
    }

    public double calculateRentalCost(int numberOfDays) {
        return numberOfDays * rentalRate;
    }
}
