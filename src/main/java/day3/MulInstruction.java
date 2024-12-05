package day3;

public class MulInstruction {

	private int left;
	private int right;
	
	public MulInstruction(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	protected int getLeft() {
		return left;
	}
	protected void setLeft(int left) {
		this.left = left;
	}
	protected int getRight() {
		return this.right;
	}
	protected void setRight(int right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "{left: " + left + ", right:  " + right + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof MulInstruction)) { return false; }
        MulInstruction other = (MulInstruction) obj;

        if(this.left != other.left) { return false; }
        if(this.right != other.right) { return false; }
        
        return true;
    }

}
