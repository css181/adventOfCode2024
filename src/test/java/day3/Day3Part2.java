package day3;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part2 {

	private Day3 day3;
	
	@BeforeEach
	public void setup() {
		day3 = new Day3(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<MulInstruction> expectedMulInstructionList = new ArrayList<MulInstruction>();
		
		expectedMulInstructionList.add(new MulInstruction(2, 4));
		expectedMulInstructionList.add(new MulInstruction(8, 5));
		
		assertEquals(expectedMulInstructionList, day3.getDoDontMulInstructions());
	}
	
	@Test
	void verify_sum_of_all_valid_mulInstructions_is_161() throws Exception {
		assertEquals(48, day3.getSumOfAllMulInstructions(day3.getDoDontMulInstructions()));
	}
	
	@Test
	void part2_answer() throws Exception {
		day3 = new Day3();
//		System.out.println(day3.getSumOfAllMulInstructions(day3.getDoDontMulInstructions()));
	}
}
