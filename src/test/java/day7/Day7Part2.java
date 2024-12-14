package day7;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day7.Equation.OPS;

public class Day7Part2 {

	private Day7 day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7(new File(getClass().getResource("SampleInput.txt").getPath()), true);
	}

	@Test
	void verify_fourth_equasion_is_valid_by_concat() throws Exception {
		assertEquals(true, day7.getEquasions().get(3).isValid());
		assertEquals(Arrays.asList(OPS.CONCAT), day7.getEquasions().get(3).getIsMultOpperators());
	}

	@Test
	void verify_fifth_equasion_is_valid_by_concat() throws Exception {
		assertEquals(true, day7.getEquasions().get(4).isValid());
		assertEquals(Arrays.asList(OPS.MULT, OPS.CONCAT, OPS.MULT), day7.getEquasions().get(4).getIsMultOpperators());
	}

	@Test
	void verify_seventh_equasion_is_valid_by_concat() throws Exception {
		assertEquals(true, day7.getEquasions().get(6).isValid());
		assertEquals(Arrays.asList(OPS.CONCAT, OPS.PLUS), day7.getEquasions().get(6).getIsMultOpperators());
	}
	
	@Test
	void verify_sum_of_all_valid_equasions_from_sample_is_3749() throws Exception {
		assertEquals(11387, day7.getSumOfAllEqualsOfValidEquasions());
	}
	
//	@Test
	void part2_answer() throws Exception {
		day7 = new Day7(true);
//		System.out.println(day7.getSumOfAllEqualsOfValidEquasions());
		assertEquals(333027885676693l, day7.getSumOfAllEqualsOfValidEquasions());
	}
}
