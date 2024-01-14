public class Bicycle extends Vehicle {
    private String type;

    private boolean isElectric;

    public Bicycle(String registrationNumber, String make, String model, int year,
    String type, boolean isElectric) {
        super(registrationNumber, make, model, year, 20);
        this.type = type;
        this.isElectric = isElectric;
    }

    @Override
    public double calculateRentalCost(int numberOfDays) {
        double cost = 0;
        
        cost += isElectric ? 20 : 0;

        cost += super.calculateRentalCost(numberOfDays);

        return cost;
    }
}
