package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    @Test
	public void testEmptyString() {
		Calculator calc = new Calculator();
		assertEquals(0, calc.add(""));
	}

	    @Test
	public void testOneNumber() {
		Calculator calc = new Calculator();
		assertEquals(4, calc.add("4"));
		assertEquals(0, calc.add("0"));
	}
}