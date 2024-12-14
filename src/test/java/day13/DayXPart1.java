package day13;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart1 {

	private Day13 day13;
	
	@BeforeEach
	public void setup() {
		day13 = new Day13(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<ClawMachine> expectedClawMachines = new ArrayList<ClawMachine>();
		expectedClawMachines.add(new ClawMachine("Button A: X+94, Y+34", "Button B: X+22, Y+67", "Prize: X=8400, Y=5400"));
		expectedClawMachines.add(new ClawMachine("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=12748, Y=12176"));
		expectedClawMachines.add(new ClawMachine("Button A: X+17, Y+86", "Button B: X+84, Y+37", "Prize: X=7870, Y=6450"));
		expectedClawMachines.add(new ClawMachine("Button A: X+69, Y+23", "Button B: X+27, Y+71", "Prize: X=18641, Y=10279"));
		
		assertEquals(expectedClawMachines, day13.clawMacines);
		assertEquals(94, day13.clawMacines.get(0).getAbutton().getX());
		assertEquals(34, day13.clawMacines.get(0).getAbutton().getY());
	}
	
	@Test
	void verify_first_machine_wins_with_80_and_40_a_and_b_presses() throws Exception {
		WinningPresses expectedMachine1WinningPresses = new WinningPresses(80, 40);
		assertEquals(expectedMachine1WinningPresses, day13.calculateWinningPresses().get(0));
	}
	
	@Test
	void verify_other_machine_wins_are_none_38_and_86_and_none() throws Exception {
		WinningPresses expectedMachine2WinningPresses = null;
		WinningPresses expectedMachine3WinningPresses = new WinningPresses(38, 86);
		WinningPresses expectedMachine4WinningPresses = null;
		assertEquals(expectedMachine2WinningPresses, day13.calculateWinningPresses().get(1));
		assertEquals(expectedMachine3WinningPresses, day13.calculateWinningPresses().get(2));
		assertEquals(expectedMachine4WinningPresses, day13.calculateWinningPresses().get(3));
	}
	
	@Test
	void verify_total_cost_of_tokens_for_all_machine_wins_is_480() throws Exception {
		assertEquals(480, day13.calculateTotalCostForWinningAllPossibleMachines());
	}
	
	@Test
	void part1_answer() throws Exception {
		day13 = new Day13();
//		System.out.println(day13.calculateTotalCostForWinningAllPossibleMachines());
		assertEquals(25751, day13.calculateTotalCostForWinningAllPossibleMachines());
	}

}
