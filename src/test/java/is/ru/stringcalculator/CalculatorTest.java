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
		try {
			assertEquals(0, calc.add(""));
		} catch (Exception e) {

		}
	}

	@Test
	public void testOneNumber() {
		Calculator calc = new Calculator();
		try {
			assertEquals(4, calc.add("4"));
			assertEquals(0, calc.add("0"));
		} catch (Exception e) {

		}
	}
	@Test
	public void testTwoNumbers() {
		Calculator calc = new Calculator();
		try {
			assertEquals(9, calc.add("4,5"));
			assertEquals(0, calc.add("0,0"));
			assertEquals(8, calc.add("4,4"));
		} catch (Exception e) {

		}
	}

		@Test
	public void testManyNumbers() {
		Calculator calc = new Calculator();
		try {
			assertEquals(6, calc.add("1,1,1,1,1,1"));
			assertEquals(0, calc.add("0,0,0,0"));
			assertEquals(14, calc.add("4,4,5,1"));
		} catch (Exception e) {

		}
	}

	@Test
	public void testOnlyComma() {
		Calculator calc = new Calculator();
		try {
			assertEquals(0, calc.add(","));
		} catch (Exception e) {

		}
	}

	@Test
	public void testEmptyAfterComma() {
		Calculator calc = new Calculator();
		try {
			assertEquals(5, calc.add("5,"));
			assertEquals(5, calc.add(",5"));
		} catch (Exception e) {

		}
	}

	@Test
	public void testNewLineDelimiter() {
		Calculator calc = new Calculator();
		try {
			assertEquals(10, calc.add("5\n5"));
			assertEquals(0, calc.add("0\n0"));
			assertEquals(1, calc.add("0\n1"));
			assertEquals(1, calc.add("1,\n"));
		} catch (Exception e) {

		}
	}

	@Test
	public void testCustomNewLineDelimiter() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.add("//;\n1;2"));
			assertEquals(7, calc.add("//;\n5;2"));
			assertEquals(10, calc.add("//;\n5;2;3"));
			assertEquals(10, calc.add("//&\n5&2&3"));
			assertEquals(10, calc.add("//A\n5A2A3"));
		} catch (Exception e) {

		}
	}

	@Test
	public void testCustomDelimiterFunction() {
		Calculator calc = new Calculator();
		try {
			assertEquals(";", calc.customDelimiter("//;\n1;2"));
			assertEquals(";", calc.customDelimiter("//;\n5;2"));
			assertEquals(";", calc.customDelimiter("//;\n5;2;3"));
			assertEquals("&", calc.customDelimiter("//&\n5&2&3"));
			assertEquals("A", calc.customDelimiter("//A\n5A2A3"));
		} catch (Exception e) {

		}
	}

		@Test
	public void testNegativeNumberException() {
		Calculator calc = new Calculator();
		try {
			calc.add("-1,-7,6,3");
		} catch (NegativeNumberException e) {
			assertEquals("Negatives not allowed: -1,-7", e.getMessage());
		}
	}

		@Test
	public void testNumbersLargerThanThousand() {
		Calculator calc = new Calculator();
		try {
			assertEquals(2, calc.add("1001,2"));
			assertEquals(25, calc.add("1001,25"));
			assertEquals(25, calc.add("//$\n10019$25"));
		} catch (Exception e) {

		}
	}
}




















