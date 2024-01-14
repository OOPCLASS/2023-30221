package ro.utcn;

import java.util.Arrays;

/*imports, methods*/
public class Main {
    /*files are with big case cuz if used in code will recognize a CLASS
    methods names or var in lower case
    camel_class pt class "MyProgram"
    in general we don't use comment try to make code readable by correct names
    classes are grouped in folder by functionality
    */
    static final int MY_CONSTANT = 100; //final keyword for constants
    static int myVariable = 22;

    public static void main(String[] args) { //args can any; in parentheses ptr
        System.out.println("Hello world");
        System.out.println(myVariable);
        System.out.println(MY_CONSTANT);
        System.out.println(Arrays.toString(args));
        /*
        `command + click` on a class like system gets u there
        `out` obj
        `println` a method
         */
        //for each loop
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}