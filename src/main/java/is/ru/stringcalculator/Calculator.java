package is.ru.stringcalculator;

public class Calculator {
	
	public int add(String numbers) {
		String[] numberArr = numbers.split(",");
		int addedValue = 0;

		for(int i = 0; i < numberArr.length; i++) {
			if (!numberArr[i].equals("")) {
				addedValue += toInt(numberArr[i]);
			}
		}

		return addedValue;
	}

	private int toInt(String s) {
		if(s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
		
	}
}