package day2;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Report {

	public int id;
	private ArrayList<Integer> levels = new ArrayList<>();
	
	public Report(int id, String inputLine) {
		this.id = id;
		int[] arr = Arrays.stream(inputLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		for (int elem : arr) {
			levels.add(elem);
		}
	}
	public Report(int id, ArrayList<Integer> levels) {
		this.id = id;
		this.levels = levels;
	}
	
	protected ArrayList<Integer> getLevels() {
		return levels;
	}
	protected void setLevels(ArrayList<Integer> levels) {
		this.levels = levels;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Report)) { return false; }
        Report other = (Report) obj;

        if(!this.levels.equals(other.levels)) { return false; }
        
        return true;
    }

    abstract public boolean isSafe();
}
