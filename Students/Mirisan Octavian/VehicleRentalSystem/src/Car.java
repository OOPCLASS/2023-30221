public class Car extends Vehicle
{
    int numberOfDoors;
    boolean hasAC;
    boolean hasAutomaticTransmission;


    public Car(String registrationNumber, String make, String model, int year, double rentalRate, boolean isRented, int numberOfDoors, boolean hasAC, boolean hasAutomaticTransmission)
    {
        super(registrationNumber, make, model, year, rentalRate, isRented);
        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.hasAutomaticTransmission = hasAutomaticTransmission;
    }

    @Override
    public double calculateRentalCostDays(int days)
    {
        return super.calculateRentalCostDays(days);
    }
}
