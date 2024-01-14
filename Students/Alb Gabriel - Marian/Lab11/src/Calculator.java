public class Calculator {

  public Long add(Long a, Long b) {
    if (a == null && b == null) {
      return 0L;
    }
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    return a + b;
  }

  public Long subtract(Long a, Long b){
    if (a == null && b == null) {
      return 0L;
    }
    if (a == null) {
      return -b;
    }
    if (b == null) {
      return a;
    }
    return a - b;
  }

  public Long multiply(Long a, Long b) {
    if (a == null && b == null) {
      return 0L;
    }
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    return a * b;
  }

  public Long divide(Long a, Long b) {
    if (a == null || a == 0L) {
      return 0L;
    }

    if (b == null || b == 0L) {
      throw new IllegalArgumentException("Cannot divide by zero or null");
    }

    return a / b;
  }
}
