package calculator;

class StringCalculator {

    public int add(String input) {
    	if (input.isEmpty()) {
    		return 0;
    	}
    	
    	if(input.length()==1) {
			return stringToInt(input);
		}
    	
    	String[] numbers=input.split(",");
    	
    	int sum=0;
		for (String i:numbers) {
			sum=sum+stringToInt(i);
		}
		return sum;
    }
    
    private static int stringToInt(String input) {
		return Integer.parseInt(input);
	}

}