package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Day1Part1 {

	private NumbersFromInputLines day1;
	
	@BeforeEach
	public void setup() {
		day1 = new NumbersFromInputLines();
	}
	private void useSampleImput() {
		day1.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day1.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<>(Arrays.asList('1','a','b','c','2')));
		expected.add(new ArrayList<>(Arrays.asList('p','q','r','3','s','t','u','8','v','w','x')));
		expected.add(new ArrayList<>(Arrays.asList('a','1','b','2','c','3','d','4','e','5','f')));
		expected.add(new ArrayList<>(Arrays.asList('t','r','e','b','7','u','c','h','e','t')));
		
		day1.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day1.populateInput();
		assertEquals(expected, day1.getInputLines());
	}
	
	@Test
	void get_first_num_in_each_list() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,3,1,7));
		
		day1.calculateFirstNumbers();
		assertEquals(expected, day1.getFirstNumbers());
	}
	
	@Test
	void get_last_num_in_each_list() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,8,5,7));
		
		day1.calculateLastNumbers();
		assertEquals(expected, day1.getLastNumbers());
	}
	
	@Test
	void get_two_digit_numbers() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(12, 38, 15, 77));
		
		day1.calculateTwoDigitNumbers();
		assertEquals(expected, day1.getTwoDigitNumbers());
	}
	
	@Test
	void adding_all_twoDigitNumbers() throws Exception {
		useSampleImput();
		long expected = 142l;
		
		assertEquals(expected, day1.addAllTwoDigitNumbers());
	}
	
	@Test
	void getAnswer() throws Exception {
//		System.out.println(day1.addAllTwoDigitNumbers());
		assertEquals(55477l, day1.addAllTwoDigitNumbers());
	}
}
