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

	private String[] splitString(String s, String c) {
		return s.split(c);
	}

	public String customDelimiter(String s) {
		if(s.length() < 2) { return null; }
		if (s.substring(0,2).equals("//")) {
			return s.substring(2,3);
		}
		return null;
	}

	public int add(String numbers) {
		String delimiter = customDelimiter(numbers);
		String[] intArr;
		// If it has a custom delimiter.
		if (delimiter != null) {
			// Remove the last line
			numbers = numbers.substring(4, numbers.length());
			numbers = normalizeDelimiters(numbers);
			intArr = splitString(numbers, delimiter);
		} else {
			numbers = normalizeDelimiters(numbers);
			intArr = splitString(numbers, ",");
		}

		int addedValue = 0;

		for(int i = 0; i < intArr.length; i++) {
			if (!intArr[i].equals("")) {
				addedValue += toInt(intArr[i]);
			}
		}

		return addedValue;
	}
}