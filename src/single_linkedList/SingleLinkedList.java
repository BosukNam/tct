package single_linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleLinkedList {
	private Node headNode;
	// 저장된 갯수 length
	
	public SingleLinkedList(){
		this.headNode = new Node();
	}
	
	public void addNode(Data data){
		Node newNode = new Node(data);
		
		Node curNode = this.headNode;
		while (curNode.getNextNode() != null) {
			curNode = curNode.getNextNode();
		}
		curNode.setNextNode(newNode);
		System.out.println(data.getIntData()+" 데이터를 가진 노드가 추가되었습니다.");
	}
	
	public boolean removeLastNode(){
		Node curNode = this.headNode;
		Node curNextNode = curNode.getNextNode();
		
		if(curNextNode==null){
			System.out.println("삭제할 노드가 없습니다.");
			return false;
		}
		
		
		while(curNextNode.getNextNode()!=null){
			curNode = curNextNode;
			curNextNode = curNextNode.getNextNode();
		}
		System.out.println(curNextNode.getData().getIntData()+" 데이터를 가진 노드가 삭제되었습니다.");
		curNode.setNextNode(null);
		return true;
	}
	
	public int removeAllNode(){
		Node curNode = this.headNode;
		Node curNextNode = curNode.getNextNode();
		
		if(curNextNode==null){
			System.out.println("삭제할 노드가 없습니다.");
			return 0;
		}
		
		Stack<Character> stack = new Stack<>();
		String a= "Asdfadfs";
		Character ch = stack.pop();
		if(ch.equals('1')){
			
		}
		stack.pop();
		
		int in=1;
		in = in << 1;
		
		int cnt=0;
		while(curNextNode.getNextNode()!=null){
			System.out.println(curNextNode.getData().getIntData()+" 데이터를 가진 노드가 삭제되었습니다.");
			curNode.setNextNode(null);
			cnt++;
			
			curNode = curNextNode;
			curNextNode = curNextNode.getNextNode();
		}
		System.out.println(curNextNode.getData().getIntData()+" 데이터를 가진 노드가 삭제되었습니다.");
		curNode.setNextNode(null);
		cnt++;
		
		return cnt;
	}
	
	public Node searchData(Data data){
		Node curNode = this.headNode.getNextNode();
		if(curNode==null){
			System.out.println("저장된 노드가 없어 데이터를 찾을 수 없습니다.");
			return null;
		}
		
		int cnt=1;
		while(curNode!=null){
			if(curNode.getData().equals(data)){
				System.out.println(cnt+"번째 노드에서 해당 데이터를 찾았습니다!"); 
				return curNode;
			}
			cnt++;
			curNode = curNode.getNextNode();
		}
		
		System.out.println("해당 데이터를 찾을 수 없습니다.");
		return null;
	}
	
	public List<Node> searchDuplicatedData(Data data){
		List<Node> resList = new ArrayList<>();
		
		Node curNode = this.headNode.getNextNode();
		if(curNode==null){
			System.out.println("저장된 노드가 없어 데이터를 찾을 수 없습니다.");
			return null;
		}
		
		int cnt=1;
		while(curNode!=null){
			if(curNode.getData().equals(data)){
				System.out.println(cnt+"번째 노드에서 해당 데이터를 찾았습니다!");
				resList.add(curNode);
			}
			cnt++;
			curNode = curNode.getNextNode();
		}
		
		if(resList.size()==0){
			System.out.println("해당 데이터를 찾을 수 없습니다.");
			return null;
		}
		else{
			return resList;
		}
	}
	
	// delete, dupdelete, sort 
	
	public void display(){
		Node curNode = this.headNode.getNextNode();
		if(curNode==null){
			System.out.println("저장된 노드가 없습니다.");
			return;
		}
		
		int cnt=1;
		while(curNode!=null){
			System.out.println(cnt+"번째 노드 값 : "+curNode.getData().getIntData());
			cnt++;
			curNode = curNode.getNextNode();
		}
	}
}
