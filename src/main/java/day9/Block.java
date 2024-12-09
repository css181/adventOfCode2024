package day9;

import java.util.ArrayList;

public class Block {

	private ArrayList<Integer> values;
	private int freeSlots;
	
	public Block(ArrayList<Integer> values, int freeSlots) {
		super();
		this.values = values;
		this.freeSlots = freeSlots;
	}


	protected ArrayList<Integer> getValues() {
		return values;
	}
	protected void setValues(ArrayList<Integer> values) {
		this.values = values;
	}
	protected int getFreeSlots() {
		return this.freeSlots;
	}
	public void getSetFreeSlots(int freeSlots) {
		this.freeSlots = freeSlots;
	}

	@Override
	public String toString() {
		return "{values: " + values + ", freeSlots:  " + freeSlots + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Block)) { return false; }
        Block other = (Block) obj;

        if(!this.values.equals(other.values)) { return false; }
        if(this.freeSlots != other.freeSlots) { return false; }
        
        return true;
    }



}
