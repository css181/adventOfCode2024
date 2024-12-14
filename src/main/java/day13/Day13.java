package day13;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;

public class Day13 {

	private static File file;
	protected ArrayList<ClawMachine> clawMacines = new ArrayList<ClawMachine>();

	public Day13() {
		clawMacines = new ArrayList<ClawMachine>();
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day13(File file) {
		clawMacines = new ArrayList<ClawMachine>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day13.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for(int x=0; x<inputLines.size(); x+=4) {
			clawMacines.add(new ClawMachine(inputLines.get(x), inputLines.get(x+1), inputLines.get(x+2)));
		}
	}
	
	public ArrayList<WinningPresses> calculateWinningPresses() {
		ArrayList<WinningPresses> winningPresses = new ArrayList<WinningPresses>();
		for (ClawMachine clawMachine : clawMacines) {			
			winningPresses.add(calculateWinningForMachine(clawMachine));
		}
		return winningPresses;
	}
	
	private WinningPresses calculateWinningForMachine(ClawMachine machine) {
		int prizeX = machine.getPrize().getX();
		int prizeY = machine.getPrize().getY();
		
		int aX = machine.getAbutton().getX();
		int aY = machine.getAbutton().getY();
		int bX = machine.getBbutton().getX();
		int bY = machine.getBbutton().getY();
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if((aX*i + bX*j == prizeX)  && (aY*i + bY*j == prizeY)) {
					return new WinningPresses(i, j);
				}
			}
		}
		return null;
	}

	public Integer calculateTotalCostForWinningAllPossibleMachines() {
		int total = 0;
		for (WinningPresses presses : calculateWinningPresses()) {
			if(presses!=null) {
				total+=presses.getB() + presses.getA()*3;
			}
		}
		return total;
	}
}
