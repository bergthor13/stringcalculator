package is.ru.stringcalculator;


public class Calculator {
	
	private int toInt(String s) {
		if(s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}

	private String[] normalizeAndSplit(String numbers, String delimiter) {
		
		numbers = numbers.replaceAll("\\n", ",");
		String[] intArr = numbers.split(delimiter);
		return intArr;
	}

	public String customDelimiter(String numbers) {
		if(numbers.length() < 2) { return null; }
		if (numbers.substring(0,2).equals("//")) {
			return numbers.substring(2,3);
		}
		return null;
	}

	public int add(String numbers) {
		String delimiter = customDelimiter(numbers);
		String[] intArr;
		// If it has a custom delimiter.
		if (delimiter != null) {
			// Remove the last line and split the numbers.
			numbers = numbers.substring(4, numbers.length());
			intArr = normalizeAndSplit(numbers, delimiter);
		} else {
			// Split the numbers normally.
			intArr = normalizeAndSplit(numbers, ",");
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