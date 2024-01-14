public class Car extends Vehicle {
    private int numberOfDoors;

    private boolean hasAC;

    private boolean hasAutomaticTransmission;

    public Car(String registrationNumber, String make, String model, int year,
    int numberOfDoors, boolean hasAC, boolean hasAutomaticTransmission) {
        super(registrationNumber, make, model, year, 100);
        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.hasAutomaticTransmission = hasAutomaticTransmission;
    }

    @Override
    public double calculateRentalCost(int numberOfDays) {
        double cost = 0;

        cost += numberOfDoors == 5 ? 5 : 0;
        cost += hasAC ? 10 : 0;
        cost += hasAutomaticTransmission ? 50 : 0;

        cost += super.calculateRentalCost(numberOfDays);

        return cost;
    }
}
