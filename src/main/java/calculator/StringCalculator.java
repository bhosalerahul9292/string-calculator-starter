package calculator;


class StringCalculator {

    public int add(String input) {
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
    	
    	int sum=0;
		for (String i:numbers) {
			if (i.isBlank()) {
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