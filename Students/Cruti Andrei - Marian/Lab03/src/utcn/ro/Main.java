package utcn.ro;

public class Main {
    public static void main(String[] args) {
        Phone firstPhone = new Phone("1233243", "Nokia", false);
        System.out.println("Phone was received at: " + firstPhone.getDate());
        System.out.println(firstPhone);
        firstPhone.setRepairStatus(true);
        firstPhone.tweakVolume(101, true);
        firstPhone.setDate();
        System.out.println(firstPhone);
        firstPhone.powerOff();
    }
}