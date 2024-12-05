package day4;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4Part1 {

	private Day4 day4;
	
	@BeforeEach
	public void setup() {
		day4 = new Day4(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<ArrayList<Character>> expectedPuzzle = new ArrayList<ArrayList<Character>>();
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('M','M','M','S','X','X','M','A','S','M')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('M','S','A','M','X','M','S','M','S','A')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('A','M','X','S','X','M','A','A','M','M')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('M','S','A','M','A','S','M','S','M','X')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('X','M','A','S','A','M','X','A','M','M')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('X','X','A','M','M','X','X','A','M','A')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('S','M','S','M','S','A','S','X','S','S')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('S','A','X','A','M','A','S','A','A','A')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('M','A','M','M','M','X','M','M','M','M')));
		expectedPuzzle.add(new ArrayList<>(Arrays.asList('M','X','M','X','A','X','M','A','S','X')));
		
		assertEquals(expectedPuzzle, day4.puzzle);
	}
	
	@Test
	void verify_forward_search_is_3() throws Exception {
		assertEquals(3, day4.getTotalHorizontalFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S'))));
	}
	@Test
	void verify_backwards_search_is_2() throws Exception {
		assertEquals(2, day4.getTotalHorizontalFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X'))));
	}
	@Test
	void verify_forward_vertical_search_is_1() throws Exception {
		assertEquals(1, day4.getTotalVerticalFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S'))));
	}
	@Test
	void verify_backwards_vertical_search_is_2() throws Exception {
		assertEquals(2, day4.getTotalVerticalFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X'))));
	}
	@Test
	void verify_forward_diagonal_down_search_is_1() throws Exception {
		assertEquals(1, day4.getTotalDiagonalDownFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S'))));
	}
	@Test
	void verify_backwards_diagonal_down_search_is_4() throws Exception {
		assertEquals(4, day4.getTotalDiagonalDownFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X'))));
	}
	@Test
	void verify_forward_diagonal_up_search_is_4() throws Exception {
		assertEquals(4, day4.getTotalDiagonalUpFindsInPuzzle(new ArrayList<>(Arrays.asList('X','M','A','S'))));
	}
	@Test
	void verify_backwards_diagonal_up_search_is_1() throws Exception {
		assertEquals(1, day4.getTotalDiagonalUpFindsInPuzzle(new ArrayList<>(Arrays.asList('S','A','M','X'))));
	}
	
	@Test
	void verify_all_finds_total_18() throws Exception {
		assertEquals(18, day4.getAllTotalFinds());
	}
	
	@Test
	void part1_answer() throws Exception {
		day4 = new Day4();
//		System.out.println(day4.getAllTotalFinds());
		assertEquals(2543, day4.getAllTotalFinds());
	}
}
