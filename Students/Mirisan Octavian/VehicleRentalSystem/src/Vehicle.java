public class Vehicle
{
    String registrationNumber;
    String make;
    String model;
    int year;
    double rentalRate;
    boolean isRented;

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


    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Vehicle(String registrationNumber, String make, String model, int year, double rentalRate, boolean isRented) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
        this.isRented = isRented;
    }

    public void rent()
    {
        this.isRented=true;
    }

    public void returnVehicle()
    {
        this.isRented=false;
    }

    public double calculateRentalCostDays(int days)
    {
        return rentalRate*days;
    }
}
