import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Vehicle> list = new ArrayList<Vehicle>();
        int numberOfDays = 3;
        
        Car car = new Car("123", "Audi", "TT", 2003, 3, 
        true, false);

        Bicycle bicycle = new Bicycle("234", "Trek", "Marlin 5", 2023,
        "Mountain", false);

        Motorcycle motorcycle = new Motorcycle("345", "Kawasaki", "Ninja",
        2023, 125, true);

        list.add(car);
        list.add(bicycle);
        list.add(motorcycle);

        for (Vehicle vehicle : list) {
            System.out.println("Rental cost for " + vehicle.getClass().getName() +
            " (" + vehicle.getMake() + " " + vehicle.getModel() + ")" + " for " + 
            numberOfDays + " days: " + vehicle.calculateRentalCost(numberOfDays));
        }

        car.rent();
        bicycle.rent();
        motorcycle.rent();

        car.returnVehicle();
        bicycle.returnVehicle();
        motorcycle.returnVehicle();
    }
}
