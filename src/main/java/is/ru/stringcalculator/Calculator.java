package is.ru.stringcalculator;
import java.util.ArrayList;
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

	public int add(String numbers) throws NegativeNumberException{
		String delimiter = customDelimiter(numbers);
		String[] intArr;
		ArrayList negativeNumbers = new ArrayList();
		// The total value
		int addedValue = 0;
		boolean hasNegativeNumber = false;
		// If it has a custom delimiter.
		if (delimiter != null) {
			// Remove the last line and split the numbers.
			numbers = numbers.substring(4, numbers.length());
			intArr = normalizeAndSplit(numbers, delimiter);
		} else {
			// Split the numbers normally.
			intArr = normalizeAndSplit(numbers, ",");
		}

		// Go through all of the numbers in
		// 'intArr' and add them together.
		int currentValue = 0;
		for(int i = 0; i < intArr.length; i++) {
			currentValue = toInt(intArr[i]);
			if (!intArr[i].equals("")) {
				if (!(currentValue > 1000)) {
					addedValue += currentValue;
				}
				if (currentValue < 0) {
					negativeNumbers.add(currentValue);
					hasNegativeNumber = true;
				}
			}
		}
		if (hasNegativeNumber) {
			String exMessage = "Negatives not allowed: ";
			for (int i = 0; i<negativeNumbers.size(); i++) {
				if (i == negativeNumbers.size()-1) {
					exMessage += negativeNumbers.get(i);
				} else {
					exMessage += negativeNumbers.get(i) + ",";
				}
			}
			throw new NegativeNumberException(exMessage);
		}
		return addedValue;
	}
}