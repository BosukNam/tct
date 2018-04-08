package binary_tree;

public class Node {
	private Data data;
	private Node left;
	private Node right;
	
	public Node(Data data){
		this.data = data;
		this.left=null;
		this.right=null;
	}
	
	public boolean hasChild(){
		if(this.left==null && this.right==null){
			return false;
		}
		return true;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
