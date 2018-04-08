package single_linkedList;

public class Node {
	private Node nextNode;
	private Data data;
	
	public Node(){
		this.nextNode=null;
		this.data=new Data();
	}

	public Node(Node nextNode) {
		super();
		this.nextNode = nextNode;
		this.data=new Data();
	}
	
	public Node(Data data) {
		super();
		this.nextNode = null;
		this.data = data;
	}

	public Node(Node nextNode, Data data) {
		super();
		this.nextNode = nextNode;
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [nextNode=" + nextNode + ", data=" + data + "]";
	}
}
