package OOP.HW;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Vehicle {

    private String registrationNumber;
    private String model;
    private int year;
    private double rentalRate;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void rent() {
        System.out.println("Vehicle rented");
    }

    public void returnedVehicle() {
        System.out.println("Vehicle returned");
    }

    public double calculateRentalCost(int numberOfDays) {
        System.out.println("Calculating total price for " + numberOfDays + " days");
        return 0;
    }

}
