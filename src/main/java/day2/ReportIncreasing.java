package day2;

public class ReportIncreasing extends Report {

	public ReportIncreasing(String inputLine) {
		super(inputLine);
	}

	@Override
	public boolean isSafe() {
		int prior = getLevels().get(0);
		for (int x=1; x<getLevels().size(); x++) {
			int current = getLevels().get(x);
			if(prior>=current) {
				return false;
			}
			if(prior+3 < current) {
				return false;
			}
			prior = current;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Increasing ~ levels: " + getLevels();
	}
}
