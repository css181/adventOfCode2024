package utilities;

public class Node {

	private String name;
	private Node left;
	private Node right;
	
	public Node(String name) {
		this.name = name;
		this.left = null;
		this.right = null;
	}
	
	public String getName() {
		return name;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "name: " + name + ", left: " + left.getName() + ", right: " + right.getName();
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Node)) { return false; }
        Node other = (Node) obj;

        if(!this.name.equals(other.name)) { return false; }
        if(!this.left.getName().equals(other.left.getName())) { return false; }
        if(!this.right.getName().equals(other.right.getName())) { return false; }
        
        return true;
    }

}
