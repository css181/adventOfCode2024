package day2;

import java.util.ArrayList;

public class ReportDecreasing extends Report {

	public ReportDecreasing(int id, String inputLine) {
		super(id, inputLine);
	}
	public ReportDecreasing(int id, ArrayList<Integer> levels) {
		super(id, levels);
		this.setLevels(levels);
	}

	@Override
	public boolean isSafe() {
		int prior = getLevels().get(0);
		for (int x=1; x<getLevels().size(); x++) {
			int current = getLevels().get(x);
			if(prior<=current) {
				return false;
			}
			if(prior-3 > current) {
				return false;
			}
			prior = current;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Decreasing ~ " + id + ": levels: " + getLevels();
	}
}
