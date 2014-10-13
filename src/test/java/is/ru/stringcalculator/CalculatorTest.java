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
	@Test
	public void testTwoNumbers() {
		Calculator calc = new Calculator();
		assertEquals(9, calc.add("4,5"));
		assertEquals(0, calc.add("0,0"));
		assertEquals(0, calc.add("-4,4"));
	}
	@Test
	public void testOnlyComma() {
		Calculator calc = new Calculator();
		assertEquals(0, calc.add(","));
	}

	@Test
	public void testEmptyAfterComma() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.add("5,"));
		assertEquals(5, calc.add(",5"));
	}

	@Test
	public void testNewLineDelimiter() {
		Calculator calc = new Calculator();
		assertEquals(10, calc.add("5\n5"));
		assertEquals(0, calc.add("0\n0"));
		assertEquals(1, calc.add("0\n1"));
	}

}