package calculator;
import java.util.*;

class StringCalculator {

    public int add(String input)  throws Exception {
    	
    	if (input.isEmpty()) {
    		return 0;
    	}
  	
    	String delimiter = ",|\n";
    	
    	String mutableInput = removeWhiteSpaces(input);
    	
    	if (input.startsWith("//")) {
    		char ch = input.charAt(2);
    		delimiter = delimiter + "|" + String.valueOf(ch);
    		mutableInput = mutableInput.substring(4);
    	}
    	
    	String[] numbers=mutableInput.split(delimiter);
    	
    	List<Integer> negNumbers = checkForNegativeNumbers(numbers);
    	if (!negNumbers.isEmpty()) {
    		throw new Exception("Negatives not allowed - "+negNumbers.toString());
    	}
    	
		return calculateSum(numbers);
    }
    
    private static int calculateSum(String[] numbers) {
    	int sum=0;
		for (String i:numbers) {
			if (i.isBlank()) {
				continue;
			}
			sum=sum+stringToInt(i);
		}
		return sum;
    }
    
    private static String removeWhiteSpaces(String input) {
    	char[] strArray = input.toCharArray();
    	StringBuffer stringBuffer = new StringBuffer();
    	for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] != ' ') {
				stringBuffer.append(strArray[i]);
			}	
		}
    	return stringBuffer.toString();
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