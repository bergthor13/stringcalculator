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

	private String[] normalizeAndSplit(String numbers, String[] delimiters) {
		
		if (numbers.length() < 2) {
			String[] singleNumber = new String[1];
			singleNumber[0] = numbers;
			return singleNumber;
		}
		// If this has a custom delimiter cut it out.
		if(numbers.substring(0,2).equals("//")) {
			// Cut out.
			numbers = numbers.substring(numbers.indexOf("\n")+1, numbers.length());
			// Replace all delimiters with commas.
			for (int i = 0; i<delimiters.length; i++) {
				numbers = numbers.replaceAll(delimiters[i], ",");
			}
		}

		numbers = numbers.replaceAll("\\n", ",");
		// Then split by commas.
		String[] intArr = numbers.split(",");
		return intArr;
	}

	public String[] customDelimiter(String numbers) {

		if(numbers.length() < 2) { 
			String[] commaDelimiter = new String[1];
			commaDelimiter[0] = ",";
			return commaDelimiter; 
		}

		// If it has a custom delimiter.
		if (numbers.substring(0,2).equals("//")) {
			// Cut the numbers away.
			String onlyDelLine = new String(numbers.substring(2, numbers.indexOf("\n")));
			// If the delimiter is longer or has multiple delimiters.
			if(onlyDelLine.substring(0,1).equals("[") && (onlyDelLine.substring(onlyDelLine.length()-1,onlyDelLine.length()).equals("]"))) {

					onlyDelLine = onlyDelLine.substring(1, onlyDelLine.length()-1);
					// Split the deliminators.
					String[] splittedDelimiters = onlyDelLine.split(Pattern.quote("]["));
					// Go through all delimiters and escape them from RegEx.
					for (int i = 0; i < splittedDelimiters.length; i++) {
						splittedDelimiters[i] = Pattern.quote(splittedDelimiters[i]);
					}
					return splittedDelimiters;
			} else {
				String[] oneDelimiter = new String[1];
				oneDelimiter[0] = onlyDelLine.substring(0,1);
				return oneDelimiter;
			}
		}
		return new String[0];
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

		// VARIABLES
		//===============================================================
		// All of the delimiters, if there are any.
			String[] delimiters = customDelimiter(numbers);
		// The list of numbers to be added together.
			String[] intArr;
		// A list that holds the negative numbers.
			ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		// The total value
			int addedValue = 0;
		// The current value when iterating
		// through the array.
			int currentValue = 0;
		// A flag that indicates if the string
		// has negative numbers.
			boolean hasNegativeNumber = false;
		//===============================================================
		
		// Split the string into numbers.
		intArr = normalizeAndSplit(numbers, delimiters);
		
		// Go through all of the numbers in
		// 'intArr' and add them together.
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


















