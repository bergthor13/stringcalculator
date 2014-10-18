package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.*;
public class Calculator {
	
	private int toInt(String s) {
		if(s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}

	private String[] normalizeAndSplit(String numbers, String delimiter) {
		
		// If this has a custom delimiter cut it out.
		if(numbers.substring(0,2).equals("//")) {
			numbers = numbers.substring(numbers.indexOf("\n")+1, numbers.length());
		}

		numbers = numbers.replaceAll("\\n", ",");
		String[] intArr = numbers.split(Pattern.quote(delimiter));
		return intArr;
	}

	public String customDelimiter(String numbers) {
		String delimiter = new String();

		if(numbers.length() < 2) { return null; }

		if (numbers.substring(0,2).equals("//")) {
			String onlyDelLine = new String(numbers.substring(2, numbers.indexOf("\n")));
			if(onlyDelLine.substring(0,1).equals("[")) {

				delimiter = onlyDelLine.substring(1,onlyDelLine.indexOf("]"));
				return delimiter;
			}

			return onlyDelLine;
		}
		return null;
	}

	private void throwNegativeException(ArrayList numbers) throws NegativeNumberException {
			String exMessage = "Negatives not allowed: ";
			for (int i = 0; i<numbers.size(); i++) {
				if (i == numbers.size()-1) {
					exMessage += numbers.get(i);
				} else {
					exMessage += numbers.get(i) + ",";
				}
			}
			throw new NegativeNumberException(exMessage);
	}

	public int add(String numbers) throws NegativeNumberException{
		String delimiter = customDelimiter(numbers);
		String[] intArr;
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		// The total value
		int addedValue = 0;
		boolean hasNegativeNumber = false;
		// If it has a custom delimiter.
		if (delimiter != null) {
			// Split the numbers with the delimiter.
			intArr = normalizeAndSplit(numbers, delimiter);
		} else {
			// Split the numbers normally.
			intArr = normalizeAndSplit(numbers, ",");
		}
		// Go through all of the numbers in
		// 'intArr' and add them together.
		int currentValue = 0;
		for(int i = 0; i < intArr.length; i++) {
			// If this is a number add it.
			if (!intArr[i].equals("")) {
				// Convert string to integer.
				currentValue = toInt(intArr[i]);
				// Checking if number is over 1000.
				if (!(currentValue > 1000)) {
					addedValue += currentValue;
				}
				// Checking if number is negative.
				// If it is, add it to a list for the
				// exception to be thrown.
				if (currentValue < 0) {
					negativeNumbers.add(currentValue);
					hasNegativeNumber = true;
				}
			}
		}
		// If the string contains negative numbers,
		// throw the exception.
		if (hasNegativeNumber) {
			throwNegativeException(negativeNumbers);
		}
		// Else return the sum.
		return addedValue;
	}
}


















