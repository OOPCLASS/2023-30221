package OOP.HW;

public class Motorcycle extends Vehicle {

    public int engineDisplacement;
    public boolean isSportBike;

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public boolean isSportBike() {
        return isSportBike;
    }

    public void setSportBike(boolean sportBike) {
        isSportBike = sportBike;
    }

    @Override
    public double calculateRentalCost(int numberOfDays) {
        if (this.isSportBike)
            return 35 * numberOfDays;
        return 28 * numberOfDays;
    }

    @Override
    public void rent() {
        System.out.println("Rented " + this.getModel() + " bike");
        if (this.isSportBike)
            System.out.println("Is sport bike");
    }
}
