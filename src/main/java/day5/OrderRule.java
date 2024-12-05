package day5;

public class OrderRule {

	private int beforePage;
	private int afterPage;
	
	public OrderRule(String input) {
		this.beforePage = Integer.valueOf(input.substring(0, input.indexOf("|")));
		this.afterPage = Integer.valueOf(input.substring(input.indexOf("|")+1));
	}
	
	public OrderRule(int before, int after) {
		this.beforePage = before;
		this.afterPage = after;
	}
	
	protected int getBeforePage() {
		return beforePage;
	}
	protected void setId(int beforePage) {
		this.beforePage = beforePage;
	}
	protected int getAfterPage() {
		return this.afterPage;
	}
	protected void setAfterPage(int afterPage) {
		this.afterPage = afterPage;
	}

	@Override
	public String toString() {
		return "beforePage: " + beforePage + ", afterPage:  " + afterPage;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof OrderRule)) { return false; }
        OrderRule other = (OrderRule) obj;

        if(this.beforePage != other.beforePage) { return false; }
        if(this.afterPage != other.afterPage) { return false; }
        
        return true;
    }

}
