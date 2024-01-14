public class Main {
    public static void main(String[] args) {

        Car automaticCar = new Car("C789", "Ford", "Focus", 2022, 70.0, 4, false, false);
        Car automaticCar2 = new Car("A129", "Audi", "A5", 2020, 45.0, 2, true, true);

        System.out.println("For car 1: " + automaticCar.rent());
        System.out.println("Renting the car with automatic transmission: " + automaticCar.hasAutomaticTransmission());
        System.out.println("Renting the car with AC: " + automaticCar.hasAC());
        int rentalDays = 10;
        System.out.println("Rental cost for the car for " + rentalDays + " days: $" + automaticCar.calculateRentalCost(rentalDays));
        System.out.println("Returning the car: " + automaticCar.returnVehicle());
        System.out.println();
        rentalDays = 6;
        System.out.println("For car 2: " + automaticCar2.rent());
        System.out.println("Renting the car with automatic transmission: " + automaticCar2.hasAutomaticTransmission());
        System.out.println("Renting the car with AC: " + automaticCar2.hasAC());
        System.out.println("Rental cost for the car for " + rentalDays + " days: $" + automaticCar2.calculateRentalCost(rentalDays));
        System.out.println("Returning the car: " + automaticCar2.returnVehicle());
        System.out.println();

        Motorcycle sportBike = new Motorcycle("M123", "Honda", "CBR1000RR", 2021, 100.0, 1000, true);
        rentalDays = 2;
        System.out.println("For motorcycle: " + sportBike.rent());
        System.out.println("Renting the motorcycle with engine displacement: " + sportBike.getEngineDisplacement());
        System.out.println("Renting the motorcycle with sport bike: " + sportBike.isSportBike());
        System.out.println("Rental cost for the motorcycle for " + rentalDays + " days: $" + sportBike.calculateRentalCost(rentalDays));
        System.out.println("Returning the motorcycle: " + sportBike.returnVehicle());
        System.out.println();

        Bicycle electricBike = new Bicycle("B123", "Trek", "FX 3 Disc", 2021, 20.0, "Mountain", true);
        rentalDays = 3;
        System.out.println("For bicycle: " + electricBike.rent());
        System.out.println("Renting the bicycle with type: " + electricBike.getModel());
        System.out.println("Renting the bicycle with electric: " + electricBike.isElectric());
        System.out.println("Rental cost for the bicycle for " + rentalDays + " days: $" + electricBike.calculateRentalCost(rentalDays));
        System.out.println("Returning the bicycle: " + electricBike.returnVehicle());

    }
}
