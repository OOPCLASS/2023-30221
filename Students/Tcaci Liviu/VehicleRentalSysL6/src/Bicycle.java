public class Bicycle extends Vehicle {
    private String type;
    private boolean isElectric;

    public Bicycle(String registrationNumber, String make, String model, int year, double rentalRate,
                   String type, boolean isElectric) {
        super(registrationNumber, make, model, year, rentalRate);
        this.type = type;
        this.isElectric = isElectric;
    }

    @Override
    public double calculateRentalCost(int hours) {
        int days = Math.max(1, (int) Math.ceil((double) hours / 24.0));

        double baseCost = super.calculateRentalCost(days);
        if (isElectric()) {
            return baseCost + (baseCost * 0.1);
        } else {
            return baseCost;
        }
    }
    public boolean isElectric() {
        return isElectric;
    }
}
