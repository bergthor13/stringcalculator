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
		
		// If this has a custom delimiter cut it out.
		if (numbers.length() < 2) {
			String[] drasl = new String[1];
			drasl[0] = numbers;
			return drasl;
		}
		if(numbers.substring(0,2).equals("//")) {
			numbers = numbers.substring(numbers.indexOf("\n")+1, numbers.length());
			
			for (int i = 0; i<delimiters.length; i++) {
				numbers = numbers.replaceAll(delimiters[i], ",");
			}
		}

		numbers = numbers.replaceAll("\\n", ",");
		String[] intArr = numbers.split(",");
		return intArr;
	}

	public String[] customDelimiter(String numbers) {

		if(numbers.length() < 2) { return new String[0]; }

		// If it has a custom delimiter.
		if (numbers.substring(0,2).equals("//")) {
			// Cut the numbers away.
			String onlyDelLine = new String(numbers.substring(2, numbers.indexOf("\n")));
			// If the delimiter is longer or has multiple delimiters.
			if(onlyDelLine.substring(0,1).equals("[") && (onlyDelLine.substring(onlyDelLine.length()-1,onlyDelLine.length()).equals("]"))) {
					onlyDelLine = onlyDelLine.substring(1, onlyDelLine.length()-1);
					String[] drasl = onlyDelLine.split(Pattern.quote("]["));
					for (int i = 0; i < drasl.length; i++) {
						drasl[i] = Pattern.quote(drasl[i]);
					}
					return drasl;
			} else {
				String[] drasl2 = new String[1];
				drasl2[0] = onlyDelLine.substring(0,1);
				System.out.println("RETURNING!:" + onlyDelLine.substring(0,1) + ":THIS");
				return drasl2;
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
		String[] delimiters = customDelimiter(numbers);
		String[] intArr;
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		// The total value
		int addedValue = 0;
		boolean hasNegativeNumber = false;
		// If it has a custom delimiter.
		if (delimiters.length > 0) {
			// Split the numbers with the delimiter.
			intArr = normalizeAndSplit(numbers, delimiters);
		} else {
			// Split the numbers normally.
			String[] drasl = new String[1];
			drasl[0] = ",";
			intArr = normalizeAndSplit(numbers, drasl);
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


















