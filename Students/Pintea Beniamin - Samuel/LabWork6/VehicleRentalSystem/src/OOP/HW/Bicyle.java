package OOP.HW;

public class Bicyle extends Vehicle{
    public String type;
    public boolean isElectric;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public double calculateRentalCost(int numberOfDays) {
        if (this.isElectric)
            return 15 * numberOfDays;

        return 10 * numberOfDays;
    }

    @Override
    public void rent() {
        System.out.println("Rented " + this.getModel() + " bicycle");
        System.out.println("It is a " + this.type);
        if (this.isElectric)
            System.out.println("Is electrical");
    }
}
