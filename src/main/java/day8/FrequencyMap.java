package day8;

import java.util.ArrayList;

import utilities.Map;

public class FrequencyMap extends Map {

	private ArrayList<Character> uniqueFrequencies = new ArrayList<Character>();
	
	public FrequencyMap(ArrayList<ArrayList<Character>> area) {
		super(area);
		for(int row=0; row<area.size(); row++) {
			for(int col=0; col<area.get(row).size(); col++) {
				char curChar = area.get(row).get(col);
				if(curChar!='.' && !uniqueFrequencies.contains(curChar)) {
					uniqueFrequencies.add(curChar);
				}
			}
		}
	}
	public ArrayList<Character> getUniqueFrequencies() {
		return uniqueFrequencies;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof FrequencyMap)) { return false; }
        FrequencyMap other = (FrequencyMap) obj;

        if(!this.toString().equals(other.toString())) { return false; }
        if(!this.uniqueFrequencies.equals(other.uniqueFrequencies)) { return false; }
        
        return true;
    }
    
}

