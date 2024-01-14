public class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private boolean isSportBike;

    public Motorcycle(String registrationNumber, String make, String model, int year, double rentalRate,
                      int engineDisplacement, boolean isSportBike) {
        super(registrationNumber, make, model, year, rentalRate);
        this.engineDisplacement = engineDisplacement;
        this.isSportBike = isSportBike;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days);
        if (isSportBike()) {
            return baseCost + (baseCost * 0.2);
        } else {
            return baseCost;
        }
    }
    public boolean isSportBike() {
        return isSportBike;
    }

    public String getEngineDisplacement() {
        return engineDisplacement + "cc";
    }
}
