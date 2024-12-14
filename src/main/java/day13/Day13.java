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
		long pX = machine.getPrize().getX();
		long pY = machine.getPrize().getY();
		
		long aX = machine.getAbutton().getX();
		long aY = machine.getAbutton().getY();
		long bX = machine.getBbutton().getX();
		long bY = machine.getBbutton().getY();
		
		double as = (pX*bY - pY*bX) / (aX*bY - aY*bX);
		double bs1 = (pX - aX*as) / bX;
		double bs2 = (pY - aY*as) / bY;
		if((aX*as+bX*bs1==pX) && (aY*as+bY*bs1==pY) && (as>0) && (bs1>0) && (bs1==bs2)) {
				return new WinningPresses(as, bs1);
		}
		
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<100; j++) {
//				if(aX*i+bX*j==pX && aY*i+bY*j==pY) {
//					return new WinningPresses(i, j);
//				}
//			}
//		}
		return null;
	}

	public long calculateTotalCostForWinningAllPossibleMachines() {
		long total = 0;
		for (WinningPresses presses : calculateWinningPresses()) {
			if(presses!=null) {
				total+=presses.getB() + presses.getA()*3;
			}
		}
		return total;
	}
	
	public void adjustPrizesForPart2() {
		for (ClawMachine clawMachine : clawMacines) {
			Coordinate p = clawMachine.getPrize();
			clawMachine.setPrize(new Coordinate(p.getX()+10000000000000l, p.getY()+10000000000000l));
		}
	}
}
