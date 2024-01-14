public class Bicycle extends Vehicle
{
    String type;
    boolean isElectric;

    public Bicycle(String registrationNumber, String make, String model, int year, double rentalRate, boolean isRented, String type, boolean isElectric) {
        super(registrationNumber, make, model, year, rentalRate, isRented);
        this.type = type;
        this.isElectric = isElectric;
    }

    @Override
    public double calculateRentalCostDays(int hours) {
        return super.calculateRentalCostDays(hours);
    }
}
