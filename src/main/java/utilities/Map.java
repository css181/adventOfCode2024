package utilities;

import java.util.ArrayList;

public class Map {

	private ArrayList<ArrayList<Character>> area;
	
	public Map(ArrayList<ArrayList<Character>> area) {
		this.area = area;
	}
	public Map(String inputLines, String seperator) {
		this.area = new ArrayList<ArrayList<Character>>();
		String[] lines = inputLines.split(seperator);
		for (String line : lines) {
			ArrayList<Character> chars = new ArrayList<Character>();
			for (char c : line.toCharArray()) {
			  chars.add(c);
			}
			this.area.add(chars);
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
        
        return true;
    }
    
}

