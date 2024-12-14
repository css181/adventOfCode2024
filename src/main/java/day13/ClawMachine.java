package day13;

import utilities.Coordinate;

public class ClawMachine {

	private Coordinate prize;
	private Coordinate Abutton;
	private Coordinate Bbutton;
	
	public ClawMachine(String aButton, String bButton, String prize) {
		this.Abutton = new Coordinate(Integer.valueOf(aButton.substring(aButton.indexOf("X+")+2, aButton.indexOf(","))), 
				Integer.valueOf(aButton.substring(aButton.indexOf("Y+")+2)));
		this.Bbutton = new Coordinate(Integer.valueOf(bButton.substring(bButton.indexOf("X+")+2, bButton.indexOf(","))), 
				Integer.valueOf(bButton.substring(bButton.indexOf("Y+")+2)));
		this.prize = new Coordinate(Integer.valueOf(prize.substring(prize.indexOf("X=")+2, prize.indexOf(","))),
				Integer.valueOf(prize.substring(prize.indexOf("Y=")+2)));
	}
	

	public Coordinate getPrize() {
		return prize;
	}


	public void setPrize(Coordinate prize) {
		this.prize = prize;
	}


	public Coordinate getAbutton() {
		return Abutton;
	}


	public void setAbutton(Coordinate abutton) {
		Abutton = abutton;
	}


	public Coordinate getBbutton() {
		return Bbutton;
	}


	public void setBbutton(Coordinate bbutton) {
		Bbutton = bbutton;
	}


	@Override
	public String toString() {
		return "{Prize: " + prize + ", AButton: " + Abutton + ", BButton: " + Bbutton + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof ClawMachine)) { return false; }
        ClawMachine other = (ClawMachine) obj;

        if(!this.prize.equals(other.prize)) { return false; }
        if(!this.Abutton.equals(other.Abutton)) { return false; }
        if(!this.Bbutton.equals(other.Bbutton)) { return false; }
        
        return true;
    }

}
