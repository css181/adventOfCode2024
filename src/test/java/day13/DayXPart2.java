package day13;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart2 {

	private Day13 day13;
	
	@BeforeEach
	public void setup() {
		day13 = new Day13(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void can_adjust_all_inputs_to_have_10000000000000_x_and_y_prizes() {
		ArrayList<ClawMachine> expectedClawMachines = new ArrayList<ClawMachine>();
		expectedClawMachines.add(new ClawMachine("Button A: X+94, Y+34", "Button B: X+22, Y+67", "Prize: X=10000000008400, Y=10000000005400"));
		expectedClawMachines.add(new ClawMachine("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=10000000012748, Y=10000000012176"));
		expectedClawMachines.add(new ClawMachine("Button A: X+17, Y+86", "Button B: X+84, Y+37", "Prize: X=10000000007870, Y=10000000006450"));
		expectedClawMachines.add(new ClawMachine("Button A: X+69, Y+23", "Button B: X+27, Y+71", "Prize: X=10000000018641, Y=10000000010279"));
		
		day13.adjustPrizesForPart2();
		
		assertEquals(expectedClawMachines, day13.clawMacines);
	}
	
	@Test
	void second_and_fourth_claw_are_winnable() throws Exception {
		day13.adjustPrizesForPart2();
		ArrayList<WinningPresses> presses = day13.calculateWinningPresses();
		assertTrue(presses.get(1)!=null);
		assertTrue(presses.get(3)!=null);
	}
	
	@Test
	void part2_answer() throws Exception {
		day13 = new Day13();
		day13.adjustPrizesForPart2();
		
//		System.out.println(day13.calculateTotalCostForWinningAllPossibleMachines());
		assertEquals(108528956728655l, day13.calculateTotalCostForWinningAllPossibleMachines());
	}
}
