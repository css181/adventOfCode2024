package utilities;

public class Coordinate {

	private long x;
	private long y;
	public Coordinate(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}
	public long getX() {
		return x;
	}
	public long getY() {
		return y;
	}
	
	@Override
    public String toString() {
    	String print = "(" + x + "," + y + ")";
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

        if(!(obj instanceof Coordinate)) { return false; }
        Coordinate other = (Coordinate) obj;

        if(this.x != other.x) { return false; }
        if(this.y != other.y) { return false; }
        
        return true;
    }
    
	public Coordinate getDistanceFrom(Coordinate coordB) {
		return new Coordinate(Math.abs(x-coordB.x), Math.abs(y-coordB.y));
	}
}
