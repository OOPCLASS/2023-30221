package ro.utcn;


public class Main {

  final int MY_CONSTANT = 0;
  int myVariable = 0;

  public static void main(String[] args) {
    for (String arg : args) {
      System.out.println(arg);
    }

    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
  }

  int doSomething() {
    return 0;
  }
}
