package day13;

public class WinningPresses {

	private int a;
	private int b;


	public WinningPresses(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
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
