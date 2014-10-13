package is.ru.stringcalculator;

public class Calculator {
	public int add(String numbers) {
		String[] numberArr = numbers.split(",");
		if(numberArr[0] == "") {
			return 0;
		}
		if(numberArr.length == 2) {
			return Integer.parseInt(numberArr[0])+Integer.parseInt(numberArr[1]);
		}
		return Integer.parseInt(numberArr[0]);
	}
}