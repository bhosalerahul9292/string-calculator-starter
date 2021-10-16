package calculator;

class StringCalculator {

    public int add(String input) {
    	if (input.isEmpty()) {
    		return 0;
    	}
  	
    	String[] numbers=input.split(",|\n");
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