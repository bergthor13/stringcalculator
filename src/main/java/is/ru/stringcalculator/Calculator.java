package is.ru.stringcalculator;

public class Calculator {
	public int add(String numbers) {
		String[] numberArr = numbers.split(",");
		if(numberArr[0] == "") {
			return 0;
		}
		return Integer.parseInt(numberArr[0]);
	}
}