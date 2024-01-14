package ro.utcn;

import java.util.List;

public class Main {
    final int MY_CONSTANT = 2;
    int aNumber = 0;

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        if(args[0].equals("nu")) {
            System.out.println("Di ce?");
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }
        anotherMethod();
    }

    public static void anotherMethod() {
        System.out.println("Why?");
    }
}