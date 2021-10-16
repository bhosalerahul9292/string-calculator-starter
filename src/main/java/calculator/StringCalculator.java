package calculator;
import java.util.*;

class StringCalculator {

    public int add(String input)  throws Exception {
    	if (input.isEmpty()) {
    		return 0;
    	}
  	
    	String delimiter = ",|\n";
    	
    	String mutableInput = input;
    	
    	if (input.startsWith("//")) {
    		char ch = input.charAt(2);
    		delimiter = delimiter + "|" + String.valueOf(ch);
    		mutableInput = mutableInput.substring(4);
    	}
    	
    	String[] numbers=mutableInput.split(delimiter);
    	
    	List<Integer> negNumbers = checkForNegativeNumbers(numbers);
    	if (!negNumbers.isEmpty()) {
    		throw new Exception("Negatives not allowed "+negNumbers.toString());
    	}
    	
    	int sum=0;
		for (String i:numbers) {
			if (i.isBlank()) {
				System.out.println("found blank"+mutableInput);
				continue;
			}
			sum=sum+stringToInt(i);
		}
		return sum;
    }
    
    private static int stringToInt(String input) {
		return Integer.parseInt(input);
	}
    
    private static List<Integer> checkForNegativeNumbers(String[] numbers) {
    	List<Integer> negativeNumbers = new ArrayList<Integer>(100);
    	for (String i:numbers) {
    		if (i.isBlank()) {
				continue;
			}
			if (stringToInt(i)<0) {
				negativeNumbers.add(stringToInt(i));
			}
		}
    	return negativeNumbers;
    }

}