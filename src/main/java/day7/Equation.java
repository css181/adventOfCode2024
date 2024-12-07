package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equation{

	public enum OPS {MULT, PLUS, CONCAT};
	private long equals;
	private ArrayList<Long> opperands;
	private ArrayList<OPS> ops;
	private boolean isValid;
	
	public Equation(String inputLine) {
		this.equals = Long.valueOf(inputLine.substring(0, inputLine.indexOf(':')));
		String str[] = inputLine.substring(inputLine.indexOf(':')+2).split(" ");
	    List<String> stringList = new ArrayList<String>();
	    stringList = Arrays.asList(str);
	    this.opperands = new ArrayList<Long>();
	    for (String elem : stringList) {
			opperands.add(Long.valueOf(elem));
		}
	    
		ops = new ArrayList<OPS>();
		//Start by checking all *, then use recursion in determineIsValid() to update the array of opperators
		for(int x=0; x<opperands.size()-1; x++) {
			ops.add(OPS.MULT);
		}
		
	    this.isValid = determineIsValid();
	}

	protected long getEquals() {
		return equals;
	}
	protected void setEquals(long equals) {
		this.equals = equals;
	}
	protected ArrayList<Long> getOpperands() {
		return opperands;
	}
	protected void setOpperands(ArrayList<Long> opperands) {
		this.opperands = opperands;
	}
	public ArrayList<OPS> getIsMultOpperators() {
		return ops;
	}
	public void setIsMultOpperators(ArrayList<OPS> ops) {
		this.ops = ops;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "equals: " + equals + ", opperands:  " + opperands;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Equation)) { return false; }
        Equation other = (Equation) obj;

        if(this.equals != other.equals) { return false; }
        if(!this.opperands.equals(other.opperands)) { return false; }
        
        return true;
    }


	private boolean determineIsValid() {
		long total = 0;
		if(ops.get(0)==OPS.MULT) {
			total = opperands.get(0) * opperands.get(1);
		} else if(ops.get(0)==OPS.PLUS){
			total = opperands.get(0) + opperands.get(1);
		} else {
			String concat = String.valueOf(opperands.get(0)) + String.valueOf(opperands.get(1));
			total = Long.valueOf(concat);
		}
		for(int opperandsIndex=2; opperandsIndex<opperands.size(); opperandsIndex++) {
			if(ops.get(opperandsIndex-1)==OPS.MULT) {
				total*=opperands.get(opperandsIndex);
			} else if(ops.get(opperandsIndex-1)==OPS.PLUS) {
				total+=opperands.get(opperandsIndex);
			} else {
				String concat = String.valueOf(total) + String.valueOf(opperands.get(opperandsIndex));
				total = Long.valueOf(concat);
			}
		}
		if(total==equals) {
			return true;
		}
		//all Plus means there's nothing more we can update, we're not valid
		if(alreadyOnAllPlus()) {
			return false;
		}
		
		//update current to plus if on *, if on + make it * and make next one +
		updateOpsToNextOpToTry();
		return determineIsValid();
	}

	private void updateOpsToNextOpToTry() {
		for(int x=ops.size()-1; x>=0; x--) {
			if(ops.get(x)==OPS.MULT) {
				ops.set(x, OPS.CONCAT);
				for(int y=x+1; y<ops.size(); y++) {
					ops.set(y, OPS.MULT);
				}
				return;
			} else if(ops.get(x)==OPS.CONCAT) {
				ops.set(x, OPS.PLUS);
				for(int y=x+1; y<ops.size(); y++) {
					ops.set(y, OPS.MULT);
				}
				return;
			}
		}
	}

	private boolean alreadyOnAllPlus() {
		for (OPS op : ops) {
			if(op==OPS.MULT || op==OPS.CONCAT) {
				return false;
			}
		}
		return true;
	}
}
