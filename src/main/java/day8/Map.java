package day8;

import java.util.ArrayList;

public class Map {

	private ArrayList<ArrayList<Character>> area = new ArrayList<ArrayList<Character>>();
	private ArrayList<Character> uniqueFrequencies = new ArrayList<Character>();
	
	public Map(ArrayList<ArrayList<Character>> area) {
		this.area = area;
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				char curChar = area.get(row).get(col);
				if(curChar!='.' && !uniqueFrequencies.contains(curChar)) {
					uniqueFrequencies.add(curChar);
				}
			}
		}
	}
	public ArrayList<ArrayList<Character>> getArea() {
		return area;
	}
	public void setArea(ArrayList<ArrayList<Character>> area) {
		this.area = area;
	}
	public void updateArea(int row, int col, Character newChar) {
		this.area.get(row).set(col, newChar);
	}
	public ArrayList<Character> getUniqueFrequencies() {
		return uniqueFrequencies;
	}
	
	@Override
	public String toString() {
		String print = "";
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				print+=area.get(row).get(col);
			}
			print+="\n";
		}
		return print;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Map)) { return false; }
        Map other = (Map) obj;

        if(!this.toString().equals(other.toString())) { return false; }
        if(!this.uniqueFrequencies.equals(other.uniqueFrequencies)) { return false; }
        
        return true;
    }
    
}

