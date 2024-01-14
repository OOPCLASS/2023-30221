public class Bicycle extends Vehicle {
    public enum BicycleType {
        MOUNTAIN,
        ROAD,
        CITY
    }
    private BicycleType type;
    private boolean isElectric;

    public Bicycle () {

    }

    public BicycleType getType() {
        return type;
    }

    public void setType(BicycleType type) {
        this.type = type;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days);
        if (isElectric) {
            baseCost += 5.0;
        }
        if (BicycleType.MOUNTAIN.equals(getType())) {
            baseCost += 25.0;
        }
        else if (BicycleType.ROAD.equals(getType())) {
            baseCost += 15.0;
        }
        else if (BicycleType.CITY.equals(getType())) {
            baseCost += 10.0;
        }
        return baseCost;
    }
}
