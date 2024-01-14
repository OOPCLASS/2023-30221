package laborator3;


public class Main {
    public static void main(String[] args) {

        int a = 0;
        Phone firstPhone = new Phone("Samsung");
        System.out.println(firstPhone.brandName);
        System.out.println(firstPhone.volume);
        firstPhone.imeiNumber = "123";
        Phone secondPhone = new Phone("Apple");
        secondPhone.imeiNumber = "456";

        firstPhone.powerOff();

        firstPhone = secondPhone;

        System.out.println(firstPhone.imeiNumber);
        System.out.println(secondPhone.imeiNumber);

        Phone thirdPhone = new Phone();
        thirdPhone.imeiNumber = "123";
        doSomething(thirdPhone);
        System.out.println(thirdPhone.imeiNumber);
        Phone.commonAttribute = 20;


    }

    public static void doSomething(Phone phone) {
        phone = new Phone();
        phone.imeiNumber = "abc";
    }
}