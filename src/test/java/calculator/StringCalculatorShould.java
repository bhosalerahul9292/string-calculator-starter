package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(10, stringCalculator.add("10"));
        assertEquals(100, stringCalculator.add("100"));
        assertEquals(100, stringCalculator.add("100,"));
    }
    
    @Test
    void string_with_two_numbers_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_more_than_two_numbers_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(21, stringCalculator.add("1,2,3,4,5,6"));
    }
    
    @Test
    void string_with_new_line_character_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
}
