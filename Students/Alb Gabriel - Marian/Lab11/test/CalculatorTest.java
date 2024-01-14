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
  public void testAddFirstParamNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(null, 2L);

    Assertions.assertEquals(2L, result);
  }

  @Test
  public void testAddSecondParamNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(2L, null);

    Assertions.assertEquals(2L, result);
  }

  @Test
  public void testAddBothParamsNull() {
    Calculator calculator = new Calculator();

    Long result = calculator.add(null, null);

    Assertions.assertEquals(0L, result);
  }

  /////////////////////----------------------------------

  @Test
  public void testSubtract() {
    Calculator calculator = new Calculator();
    Long result = calculator.subtract(5L, 2L);
    Assertions.assertEquals(3L, result);
  }

  @Test
  public void testSubtractFirstParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.subtract(null, 2L);
    Assertions.assertEquals(-2L, result);
  }

  @Test
  public void testSubtractSecondParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.subtract(5L, null);
    Assertions.assertEquals(5L, result);
  }

  @Test
  public void testSubtractBothParamsNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.subtract(null, null);
    Assertions.assertEquals(0L, result);
  }
  /////////////////////----------------------------------

  /////////////////////----------------------------------
  @Test
  public void testMultiply() {
    Calculator calculator = new Calculator();
    Long result = calculator.multiply(3L, 4L);
    Assertions.assertEquals(12L, result);
  }

  @Test
  public void testMultiplyFirstParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.multiply(null, 5L);
    Assertions.assertEquals(0L, result);
  }


  @Test
  public void testMultiplySecondParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.multiply(6L, null);
    Assertions.assertEquals(0L, result);
  }

  @Test
  public void testMultiplyBothParamsNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.multiply(null, null);
    Assertions.assertEquals(0L, result);
  }
  /////////////////////----------------------------------

  /////////////////////----------------------------------
  @Test
  public void testDivide() {
    Calculator calculator = new Calculator();
    Long result = calculator.divide(8L, 2L);
    Assertions.assertEquals(4L, result);
  }

  @Test
  public void testDivideFirstParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.divide(null, 5L);
    Assertions.assertEquals(0L, result);
  }

  @Test
  public void testDivideSecondParamNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.divide(6L, null);
    Assertions.assertEquals(0L, result);
  }

  @Test
  public void testDivideBothParamsNull() {
    Calculator calculator = new Calculator();
    Long result = calculator.divide(null, null);

    Assertions.assertEquals(0L, result);
  }
  /////////////////////----------------------------------



}
