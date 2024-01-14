package OOP.HW;

public class Car extends Vehicle{
    public int numberOfDoors;
    public boolean hasAC;
    public boolean hasAutomaticTransmission;

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

    @Override
    public double calculateRentalCost(int numberOfDays) {
        /// 40$
        if (this.hasAC && !this.hasAutomaticTransmission)
            return 40 * numberOfDays;
        if (this.hasAC && this.hasAutomaticTransmission)
            return 50 * numberOfDays;
        if (this.numberOfDoors != 4)
            return 35 * numberOfDays;

        return 30 * numberOfDays;
    }

    @Override
    public void rent() {
        System.out.println("Rented " + this.getModel());
        System.out.print("Has " + this.numberOfDoors + " doors");
        if (this.hasAutomaticTransmission)
            System.out.println(" and has automatic transmission");
        else
            System.out.println(" and doesn't have automatic transmission");
    }
}
