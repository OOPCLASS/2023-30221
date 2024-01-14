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
}
