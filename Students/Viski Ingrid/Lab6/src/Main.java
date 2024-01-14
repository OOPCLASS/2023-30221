public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setMake("Skoda");
        car1.setModel("Octavia");
        car1.setYear(2006);
        car1.setRegistrationNumber("STG349");
        car1.setRentalRate(40.0);
        car1.setNumberOfDoors(4);
        car1.setHasAC(true);
        car1.setHasAutomaticTransmission(false);

        Car car2 = new Car();
        car2.setMake("BMW");
        car2.setModel("X6");
        car2.setYear(2020);
        car2.setRegistrationNumber("XYA815");
        car2.setRentalRate(80.0);
        car2.setNumberOfDoors(4);
        car2.setHasAC(true);
        car2.setHasAutomaticTransmission(true);

        Car car3 = new Car();
        car3.setMake("Audi");
        car3.setModel("A5");
        car3.setYear(2021);
        car3.setRegistrationNumber("IRF250");
        car3.setRentalRate(65.0);
        car3.setNumberOfDoors(2);
        car3.setHasAC(true);
        car3.setHasAutomaticTransmission(true);

        Bicycle bicycle1 = new Bicycle();
        bicycle1.setMake("Trek");
        bicycle1.setModel("Mountain Bike");
        bicycle1.setYear(2021);
        bicycle1.setRegistrationNumber("MTB123");
        bicycle1.setRentalRate(20.0);
        bicycle1.setType(Bicycle.BicycleType.MOUNTAIN);
        bicycle1.setElectric(false);

        Bicycle bicycle2 = new Bicycle();
        bicycle2.setMake("Giant");
        bicycle2.setModel("Road Bike");
        bicycle2.setYear(2022);
        bicycle2.setRegistrationNumber("RB456");
        bicycle2.setRentalRate(18.0);
        bicycle2.setType(Bicycle.BicycleType.ROAD);
        bicycle2.setElectric(true);

        Bicycle bicycle3 = new Bicycle();
        bicycle3.setMake("Schwinn");
        bicycle3.setModel("City Bike");
        bicycle3.setYear(2020);
        bicycle3.setRegistrationNumber("CB789");
        bicycle3.setRentalRate(15.0);
        bicycle3.setType(Bicycle.BicycleType.CITY);
        bicycle3.setElectric(false);

        Motorcycle motorcycle1 = new Motorcycle();
        motorcycle1.setMake("Ducati");
        motorcycle1.setModel("Panigale V4");
        motorcycle1.setYear(2021);
        motorcycle1.setRegistrationNumber("DUC123");
        motorcycle1.setRentalRate(50.0);
        motorcycle1.setSportBike(true);
        motorcycle1.setEngineDisplacement(1100);

        Motorcycle motorcycle2 = new Motorcycle();
        motorcycle2.setMake("Harley-Davidson");
        motorcycle2.setModel("Fat Boy");
        motorcycle2.setYear(2022);
        motorcycle2.setRegistrationNumber("HD456");
        motorcycle2.setRentalRate(40.0);
        motorcycle2.setSportBike(false);
        motorcycle2.setEngineDisplacement(1600);

        Motorcycle motorcycle3 = new Motorcycle();
        motorcycle3.setMake("BMW");
        motorcycle3.setModel("R1250RT");
        motorcycle3.setYear(2020);
        motorcycle3.setRegistrationNumber("BMW1250");
        motorcycle3.setRentalRate(45.0);
        motorcycle3.setSportBike(false);
        motorcycle3.setEngineDisplacement(1250);

        displayVehicleInformation(car1);
        displayVehicleInformation(car2);
        displayVehicleInformation(car3);
        displayVehicleInformation(bicycle1);
        displayVehicleInformation(bicycle2);
        displayVehicleInformation(bicycle3);
        displayVehicleInformation(motorcycle1);
        displayVehicleInformation(motorcycle2);
        displayVehicleInformation(motorcycle3);
    }

    private static void displayVehicleInformation(Vehicle vehicle) {
        System.out.println("Vehicle Information:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("Registration Number: " + vehicle.getRegistrationNumber());
        System.out.println("Rental Rate: " + vehicle.getRentalRate());
        System.out.println("Is Rented: " + vehicle.isRented());
        System.out.println("Rental cost for 5 days: " + vehicle.calculateRentalCost(5) + "$");
        System.out.println("\n");
    }
}