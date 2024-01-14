
public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean hasAC;
    private boolean hasAutomaticTransmission;

    public Car(String registrationNumber, String make, String model, int year, double rentalRate,
               int numberOfDoors, boolean hasAC, boolean hasAutomaticTransmission) {
        super(registrationNumber, make, model, year, rentalRate);
        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.hasAutomaticTransmission = hasAutomaticTransmission;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days);
        double additionalCost = 0.0;
        if (numberOfDoors == 2) {
            additionalCost += baseCost * 0.1;
        }
        if (hasAC) {
            additionalCost += baseCost * 0.05;
        }
        if (hasAutomaticTransmission) {
            additionalCost += baseCost * 0.08;
        }

        return baseCost + additionalCost;

    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean hasAC() {
        return hasAC;
    }

    public boolean hasAutomaticTransmission() {
        return hasAutomaticTransmission;
    }
}
