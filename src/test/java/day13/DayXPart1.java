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
//[null, {A: 30, B: 10}, null, {A: 61, B: 10}, null, {A: 59, B: 86}, null, null, {A: 30, B: 97}, null, null, {A: 60, B: 58}, null, {A: 37, B: 32}, null, null, null, null, null, null, {A: 43, B: 55}, {A: 33, B: 48}, {A: 36, B: 6}, null, null, null, null, {A: 27, B: 69}, null, null, null, null, {A: 8, B: 20}, null, {A: 95, B: 69}, null, null, {A: 33, B: 79}, null, null, {A: 99, B: 49}, {A: 66, B: 12}, {A: 42, B: 94}, null, {A: 18, B: 72}, {A: 19, B: 98}, null, {A: 28, B: 96}, null, null, {A: 77, B: 26}, null, null, null, null, {A: 31, B: 99}, null, {A: 48, B: 69}, {A: 27, B: 21}, null, {A: 65, B: 42}, null, null, null, {A: 49, B: 84}, null, null, null, null, {A: 19, B: 45}, null, {A: 83, B: 72}, null, null, null, null, {A: 6, B: 27}, null, null, null, null, {A: 37, B: 62}, null, null, {A: 38, B: 24}, null, {A: 75, B: 31}, null, {A: 36, B: 17}, null, null, null, {A: 49, B: 69}, null, null, {A: 19, B: 21}, {A: 59, B: 74}, null, null, {A: 27, B: 29}, null, null, null, null, {A: 27, B: 46}, null, null, {A: 43, B: 6}, {A: 55, B: 12}, null, null, null, {A: 33, B: 57}, null, null, {A: 21, B: 76}, null, null, null, {A: 64, B: 47}, null, null, {A: 89, B: 22}, null, {A: 71, B: 43}, null, {A: 45, B: 73}, null, null, null, null, null, {A: 87, B: 28}, {A: 77, B: 64}, {A: 78, B: 67}, {A: 11, B: 48}, {A: 30, B: 54}, null, null, null, null, {A: 92, B: 23}, {A: 90, B: 61}, {A: 3, B: 94}, null, null, null, null, null, null, null, null, null, null, {A: 27, B: 71}, null, {A: 97, B: 34}, {A: 58, B: 39}, null, {A: 77, B: 52}, {A: 65, B: 12}, {A: 86, B: 35}, {A: 89, B: 31}, null, {A: 79, B: 95}, {A: 82, B: 92}, {A: 24, B: 59}, {A: 35, B: 27}, null, null, null, null, null, null, null, {A: 73, B: 41}, {A: 81, B: 59}, null, null, {A: 65, B: 50}, {A: 28, B: 71}, {A: 71, B: 67}, null, {A: 93, B: 10}, null, {A: 37, B: 21}, {A: 45, B: 49}, {A: 82, B: 94}, null, {A: 94, B: 69}, null, null, null, null, null, {A: 22, B: 99}, {A: 31, B: 28}, null, {A: 19, B: 87}, {A: 48, B: 77}, {A: 44, B: 54}, null, {A: 83, B: 18}, null, null, {A: 23, B: 95}, {A: 60, B: 83}, {A: 3, B: 5}, null, null, {A: 73, B: 58}, {A: 9, B: 69}, null, {A: 34, B: 32}, null, null, null, {A: 52, B: 16}, {A: 21, B: 93}, {A: 75, B: 67}, null, null, null, null, null, {A: 41, B: 38}, {A: 20, B: 40}, {A: 17, B: 62}, {A: 37, B: 96}, {A: 57, B: 44}, {A: 95, B: 68}, null, null, null, null, null, null, null, null, {A: 83, B: 92}, null, null, {A: 75, B: 20}, null, null, null, null, null, null, {A: 60, B: 90}, null, {A: 8, B: 50}, null, null, null, null, null, {A: 7, B: 17}, {A: 51, B: 90}, {A: 5, B: 93}, null, null, {A: 3, B: 97}, null, null, {A: 86, B: 19}, {A: 53, B: 66}, null, {A: 81, B: 35}, null, null, null, {A: 12, B: 53}, {A: 27, B: 58}, {A: 98, B: 87}, null, {A: 26, B: 96}, null, null, null, null, null, null, null, null, null, null, {A: 79, B: 41}, null, {A: 35, B: 34}, null, null, null, null, {A: 92, B: 24}, null, {A: 38, B: 4}, {A: 62, B: 22}, {A: 65, B: 42}, {A: 82, B: 62}, null, null, {A: 13, B: 68}, {A: 76, B: 51}, {A: 26, B: 83}, {A: 21, B: 99}, {A: 58, B: 32}, null, {A: 83, B: 21}, {A: 11, B: 89}, {A: 60, B: 64}, {A: 14, B: 44}, null, null, null, {A: 12, B: 98}, {A: 48, B: 10}, null, null, {A: 11, B: 6}]

}
