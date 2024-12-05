package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Day1Part2 {

	private NumbersFromInputLines day1;
	
	@BeforeEach
	public void setup() {
		day1 = new NumbersFromInputLines();
	}
	private void useSampleImput() {
		day1.setFileToUse(new File(getClass().getResource("SampleInput2.txt").getPath()));
		day1.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<>(Arrays.asList('t','w','o','1','n','i','n','e')));
		expected.add(new ArrayList<>(Arrays.asList('e','i','g','h','t','w','o','t','h','r','e','e')));
		expected.add(new ArrayList<>(Arrays.asList('a','b','c','o','n','e','2','t','h','r','e','e','x','y','z')));
		expected.add(new ArrayList<>(Arrays.asList('x','t','w','o','n','e','3','f','o','u','r')));
		expected.add(new ArrayList<>(Arrays.asList('4','n','i','n','e','e','i','g','h','t','s','e','v','e','n','2')));
		expected.add(new ArrayList<>(Arrays.asList('z','o','n','e','i','g','h','t','2','3','4')));
		expected.add(new ArrayList<>(Arrays.asList('7','p','q','r','s','t','s','i','x','t','e','e','n')));
		
		day1.setFileToUse(new File(getClass().getResource("SampleInput2.txt").getPath()));
		day1.populateInput();
		assertEquals(expected, day1.getInputLines());
	}
	
	@Test
	void get_first_num_in_each_list() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,8,1,2,4,1,7));
		
		day1.calculateFirstNumbersPart2();
		assertEquals(expected, day1.getFirstNumbers());
	}
	
	@Test
	void get_last_num_in_each_list() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(9,3,3,4,2,4,6));
		
		day1.calculateLastNumbersPart2();
		assertEquals(expected, day1.getLastNumbers());
	}
	
	@Test
	void get_two_digit_numbers() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(29, 83, 13, 24, 42, 14, 76));
		
		day1.calculateTwoDigitNumbersPart2();
		assertEquals(expected, day1.getTwoDigitNumbers());
	}
	
	@Test
	void adding_all_twoDigitNumbers() throws Exception {
		useSampleImput();
		long expected = 281l;
		
		assertEquals(expected, day1.addAllTwoDigitNumbersPart2());
	}
	
	@Test
	void getAnswer() throws Exception {
//		System.out.println(day1.addAllTwoDigitNumbersPart2());
		assertEquals(54431l, day1.addAllTwoDigitNumbersPart2());
	}
}
