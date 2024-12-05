package day1;

public class Pojo {

	private int id;
	private boolean isPossible;
	
	public Pojo(String inputLine) {
		//Assign properties from the input line
	}
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected boolean getIsPossible() {
		return this.isPossible;
	}

	@Override
	public String toString() {
		return "id: " + id + ", isPossible:  " + isPossible;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Pojo)) { return false; }
        Pojo other = (Pojo) obj;

        if(this.id != other.id) { return false; }
        if(this.isPossible != other.isPossible) { return false; }
        
        return true;
    }

}
