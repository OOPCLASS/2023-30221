package ro.utcn;

public class Main
{
    final int MY_CONSTANT = 0;
    int myVariable = 0;
    public static void main(String[] args)
    {
        System.out.println("Hello!");
        for (String s : args)
        {
            System.out.println(s + " ");
        }
        doSomething();
    }

    static void doSomething()
    {
        System.out.println("asa?");
    }
}