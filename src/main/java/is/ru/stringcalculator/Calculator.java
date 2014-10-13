package is.ru.stringcalculator;

public class Calculator {
	
	public int add(String numbers) {
		String[] numberArr = numbers.split(",");
		if (numberArr.length == 0 || numberArr[0] == "") {
			return 0;
		}

		if (numberArr.length == 2) {
			return toInt(numberArr[0]) + toInt(numberArr[1]);
		}

		return toInt(numberArr[0]);
	}

	private int toInt(String s) {
		return Integer.parseInt(s);
	}
}