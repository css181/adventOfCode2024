package day7;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day7.Equation.OPS;

public class Day7Part1 {

	private Day7 day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Equation> expectedEquasions = new ArrayList<Equation>();
		expectedEquasions.add(new Equation("190: 10 19"));
		expectedEquasions.add(new Equation("3267: 81 40 27"));
		expectedEquasions.add(new Equation("83: 17 5"));
		expectedEquasions.add(new Equation("156: 15 6"));
		expectedEquasions.add(new Equation("7290: 6 8 6 15"));
		expectedEquasions.add(new Equation("161011: 16 10 13"));
		expectedEquasions.add(new Equation("192: 17 8 14"));
		expectedEquasions.add(new Equation("21037: 9 7 18 13"));
		expectedEquasions.add(new Equation("292: 11 6 16 20"));
		
		assertEquals(expectedEquasions, day7.getEquasions());
		assertEquals(190, day7.getEquasions().get(0).getEquals());
		assertEquals(Arrays.asList(10l,19l), day7.getEquasions().get(0).getOpperands());
	}
	
	@Test
	void verify_first_equasion_is_valid_by_multiplying() throws Exception {
		assertEquals(true, day7.getEquasions().get(0).isValid());
		assertEquals(Arrays.asList(OPS.MULT), day7.getEquasions().get(0).getIsMultOpperators());
	}

	@Test
	void verify_second_equasion_is_valid_by_multiplying_then_adding_or_adding_then_multiplying() throws Exception {
		assertEquals(true, day7.getEquasions().get(1).isValid());
		assertEquals(Arrays.asList(OPS.MULT, OPS.PLUS), day7.getEquasions().get(1).getIsMultOpperators()); //Could also be (false,true)
	}

	@Test
	void verify_last_equasion_is_valid_by_plus_times_plus() throws Exception {
		assertEquals(true, day7.getEquasions().get(8).isValid());
		assertEquals(Arrays.asList(OPS.PLUS, OPS.MULT, OPS.PLUS), day7.getEquasions().get(8).getIsMultOpperators()); //Could also be (false,true)
	}
	
	@Test
	void verify_all_other_equasions_are_invalid() throws Exception {
		assertEquals(false, day7.getEquasions().get(2).isValid());
		assertEquals(false, day7.getEquasions().get(3).isValid());
		assertEquals(false, day7.getEquasions().get(4).isValid());
		assertEquals(false, day7.getEquasions().get(5).isValid());
		assertEquals(false, day7.getEquasions().get(6).isValid());
		assertEquals(false, day7.getEquasions().get(7).isValid());
	}
	
	@Test
	void verify_sum_of_all_valid_equasions_from_sample_is_3749() throws Exception {
		assertEquals(3749, day7.getSumOfAllEqualsOfValidEquasions());
	}
	
	@Test
	void part1_answer() throws Exception {
		day7 = new Day7();
//		System.out.println(day7.getSumOfAllEqualsOfValidEquasions());
		assertEquals(6231007345478l, day7.getSumOfAllEqualsOfValidEquasions());
	}
}
