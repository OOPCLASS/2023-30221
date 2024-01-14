public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Phone firstPhone = new Phone();
        firstPhone.imeiNumber = "123";
        Phone secondPhone = new Phone();
        secondPhone.imeiNumber = "456";

        System.out.println(firstPhone.imeiNumber);
        System.out.println(secondPhone.imeiNumber);

        doSomething(secondPhone);
        System.out.println(secondPhone.imeiNumber);

        Contact john = new Contact("John", 05022421);

        Phone thirdPhone = new Phone("135", 124124123);
        thirdPhone.addSimCardContact(john);

        System.out.println(thirdPhone.getSimCardContacts().getFirst().getName() + 
        " " + thirdPhone.getSimCardContacts().getFirst().getNumber());
    }

    private static void doSomething(Phone phone) {
        var newPhone = new Phone();
        phone = newPhone;
        phone.imeiNumber = "abc";
    }
}
