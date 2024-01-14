public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean hasAC;
    private boolean hasAutomaticTransmission;

    public Car() {

    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean isHasAutomaticTransmission() {
        return hasAutomaticTransmission;
    }

    public void setHasAutomaticTransmission(boolean hasAutomaticTransmission) {
        this.hasAutomaticTransmission = hasAutomaticTransmission;
    }

    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days) + 70.0;
        if (numberOfDoors > 2) {
            baseCost += 15.0;
        }
        if (hasAC) {
            baseCost += 10.0;
        }
        if (hasAutomaticTransmission) {
            baseCost += 30.0;
        }
        return baseCost;
    }
}
