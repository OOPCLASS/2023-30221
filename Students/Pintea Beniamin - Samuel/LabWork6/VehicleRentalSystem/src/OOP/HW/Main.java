package OOP.HW;

public class Main {
    public static void main(String[] args) {

        Car myCar = new Car();
        myCar.setRegistrationNumber("MS 07 JXB");
        myCar.setModel("Ford");
        myCar.setYear(2011);
        myCar.setRentalRate(0.67);

        myCar.setNumberOfDoors(4);
        myCar.setHasAC(true);
        myCar.setHasAutomaticTransmission(false);
        myCar.rent();
        System.out.println("Total rental cost for " + 3 + " days is " + myCar.calculateRentalCost(3) + "$");

        Motorcycle myBike = new Motorcycle();
        myBike.setRegistrationNumber("MS 52 BXP");
        myBike.setModel("Honda");
        myBike.setYear(2017);
        myBike.setRentalRate(0.30);

        myBike.setSportBike(true);
        myBike.rent();
        System.out.println("Total rental cost for " + 5 + " days is " + myBike.calculateRentalCost(5) + "$");

        Bicyle myBicycle = new Bicyle();
        myBicycle.setModel("BMX");
        myBicycle.setYear(2010);
        myBicycle.setRentalRate(0.61);

        myBicycle.setType("Mountain Bike");
        myBicycle.setElectric(false);
        myBicycle.rent();
        System.out.println("Total rental cost for " + 2 + " days is " + myBicycle.calculateRentalCost(2) + "$");

    }
}