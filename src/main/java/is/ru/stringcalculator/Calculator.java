package is.ru.stringcalculator;

public class Calculator {
	
	private int toInt(String s) {
		if(s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}

	private String normalizeDelimiters(String s) {
		return s.replaceAll("\\n", ",");
	}

	private String[] splitIntegers(String s) {
		return s.split(",");
	}

	public int add(String numbers) {
		numbers = normalizeDelimiters(numbers);
		String[] intArr = splitIntegers(numbers);
		int addedValue = 0;

		for(int i = 0; i < intArr.length; i++) {
			if (!intArr[i].equals("")) {
				addedValue += toInt(intArr[i]);
			}
		}

		return addedValue;
	}
}