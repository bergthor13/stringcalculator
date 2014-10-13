package is.ru.stringcalculator;

public class Calculator {
	
	public int add(String numbers) {
		numbers = numbers.replaceAll("\\n", ",");
		String[] commaArr = numbers.split(",");
		int addedValue = 0;

		for(int i = 0; i < commaArr.length; i++) {
			if (!commaArr[i].equals("")) {
				addedValue += toInt(commaArr[i]);
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