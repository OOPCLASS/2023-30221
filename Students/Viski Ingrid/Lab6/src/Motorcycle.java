public class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private boolean isSportBike;

    public Motorcycle() {

    }

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

    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days) + 45.0;
        if (isSportBike) {
            baseCost += 20.0;
        }
        if (engineDisplacement >= 1500) {
            baseCost += 30.0;
        }
        else {
            baseCost += 15.0;
        }
        return baseCost;
    }
}
