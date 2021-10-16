package calculator;

import java.util.Arrays;

class StringCalculator {

    public int add(String input) {
    	if (input.isEmpty()) {
    		return 0;
    	}
  	
    	String[] numbers=input.split(",|\n");
    	System.out.println("here"+ Arrays.toString(numbers));
    	int sum=0;
		for (String i:numbers) {
			if (i.isBlank()) {
				System.out.println("found blank"+input);
				continue;
			}
			sum=sum+stringToInt(i);
		}
		return sum;
    }
    
    private static int stringToInt(String input) {
		return Integer.parseInt(input);
	}

}