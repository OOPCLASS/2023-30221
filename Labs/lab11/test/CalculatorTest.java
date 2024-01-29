import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(1L, 2L);

    Assertions.assertEquals(3L, result);
  }

  @Test
  public void testAddOneToMaxLong() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(Long.MAX_VALUE, 1L);

    Assertions.assertEquals(0L, result);
  }

  @Test
  public void testAddFirstParamNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(null, 1L);

    Assertions.assertEquals(1L, result);
  }

  @Test
  public void testAddSecondParamNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(1L, null);

    Assertions.assertEquals(1L, result);
  }

  @Test
  public void testAddBothParamsNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(null, null);

    Assertions.assertEquals(0L, result);
  }
}
