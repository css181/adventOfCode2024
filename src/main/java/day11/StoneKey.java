package day11;

public class StoneKey {

	private long value;
	private int blinkNum;
	
	public StoneKey(long value, int blinkNum) {
		super();
		this.value = value;
		this.blinkNum = blinkNum;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public int getBlinkNum() {
		return blinkNum;
	}

	public void setBlinkNum(int blinkNum) {
		this.blinkNum = blinkNum;
	}

	@Override
	public String toString() {
		return "value: " + value + ", blinknum:  " + blinkNum;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof StoneKey)) { return false; }
        StoneKey other = (StoneKey) obj;

        if(this.value != other.value) { return false; }
        if(this.blinkNum != other.blinkNum) { return false; }
        
        return true;
    }

}
