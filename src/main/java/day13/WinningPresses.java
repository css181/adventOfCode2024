package day13;

public class WinningPresses {

	private double a;
	private double b;


	public WinningPresses(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "{A: " + a + ", B: " + b + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof WinningPresses)) { return false; }
        WinningPresses other = (WinningPresses) obj;

        if(this.a != other.a) { return false; }
        if(this.b != other.b) { return false; }
        
        return true;
    }

}
