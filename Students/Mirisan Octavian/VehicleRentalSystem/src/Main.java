public class Main
{

    public static void main(String[] args)
    {
        Car car= new Car("123","Ford","Focus",2008,150,false,4,true,true);
        Bicycle bicycle = new Bicycle("124","Pegas","Tohan",2013,25,true,"city",false);
        Motorcycle motorcycle= new Motorcycle("125","Honda","Superhawk",1997,90,false,70,true);

        car.setRented(true);

        System.out.println(car.calculateRentalCostDays(4));
        System.out.println(car.isRented());
        System.out.println(car.getMake());


        System.out.println(bicycle.getModel());


    }
}
