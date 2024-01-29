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
    if (a > 0 && b > 0 && a + b < 0) {
      return 0L;
    }
    return a + b;
  }
}
