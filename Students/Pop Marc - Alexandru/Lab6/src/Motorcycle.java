public class Motorcycle extends Vehicle {
    private int engineDisplacement;

    private boolean isSportBike;

    public Motorcycle(String registrationNumber, String make, String model, int year,
    int engineDisplacement, boolean isSportBike) {
        super(registrationNumber, make, model, year, 50);
        this.engineDisplacement = engineDisplacement;
        this.isSportBike = isSportBike;
    }

    @Override
    public double calculateRentalCost(int numberOfDays) {
        double cost = 0;

        cost += engineDisplacement * 2;
        cost += isSportBike ? 20 : 0;

        cost += super.calculateRentalCost(numberOfDays);

        return cost;
    }
}
