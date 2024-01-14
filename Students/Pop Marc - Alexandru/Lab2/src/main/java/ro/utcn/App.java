package main.java.ro.utcn;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for (String string : args) {
            System.out.println(string);
        }
        printSomething("Hi!");


    }

    private static void printSomething(String x) {
        System.out.println(x);
    }
}