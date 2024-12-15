package day14;

import utilities.Coordinate;

public class Robot {

	private Coordinate position;
	private Coordinate velocity;
	
	public Robot(String line) {
		//p=0,4 v=3,-3
		String px = line.substring(line.indexOf("p=")+2, line.indexOf(","));
		String py = line.substring(line.indexOf(",")+1, line.indexOf(" "));
		position = new Coordinate(Long.valueOf(px), Long.valueOf(py));
		
		String vx = line.substring(line.indexOf("v=")+2, line.indexOf(",", line.indexOf(",")+1));
		String vy = line.substring(line.indexOf(",", line.indexOf(",")+1)+1);
		velocity = new Coordinate(Long.valueOf(vx), Long.valueOf(vy));
	}
	public Robot(Coordinate position, Coordinate velocity) {
		super();
		this.position = position;
		this.velocity = velocity;
	}

	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	public Coordinate getVelocity() {
		return velocity;
	}
	public void setVelocity(Coordinate velocity) {
		this.velocity = velocity;
	}
	
	@Override
	public String toString() {
		return "{position: " + position + ", velocity:  " + velocity + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Robot)) { return false; }
        Robot other = (Robot) obj;

        if(!this.position.equals(other.position)) { return false; }
        if(!this.velocity.equals(other.velocity)) { return false; }
        
        return true;
    }
    
	public void move() {
		long newx = (position.getX() + velocity.getX());
		while (newx >= Day14.maxCols) {
			newx = newx - Day14.maxCols;
		}
		while (newx < 0) {
			newx = newx + Day14.maxCols;
		}
		long newy = (position.getY() + velocity.getY());
		while (newy >= Day14.maxRows) {
			newy = newy - Day14.maxRows;
		}
		while (newy < 0) {
			newy = newy + Day14.maxRows;
		}
		this.position = new Coordinate(newx, newy);
	}
	
	public int getQuartile() {
		int halfx = (int)(Day14.maxCols / 2)-1;
		int halfy = (int)(Day14.maxRows / 2)-1;
		if((position.getX()<=halfx) &&(position.getY()<=halfy)) {
			return 0;
		} else if((position.getX()<=halfx) &&(position.getY()>=halfy+2)) {
			return 2;
		} else if((position.getX()>=halfx+2) &&(position.getY()<=halfy)) {
			return 1;
		} else if((position.getX()>=halfx+2) &&(position.getY()>=halfy+2)) {
			return 3;
		} else {
			return -1;
		}
	}

}
