public class Motorcycle extends Vehicle
{
    int engineDisplacement;
    boolean isSportBike;

    public Motorcycle(String registrationNumber, String make, String model, int year, double rentalRate, boolean isRented, int engineDisplacement, boolean isSportBike) {
        super(registrationNumber, make, model, year, rentalRate, isRented);
        this.engineDisplacement = engineDisplacement;
        this.isSportBike = isSportBike;
    }

    @Override
    public double calculateRentalCostDays(int days) {
        return super.calculateRentalCostDays(days);
    }
}
