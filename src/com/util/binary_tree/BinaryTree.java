package com.util.binary_tree;

public class BinaryTree {
	private Node root;
	private int nodeCnt;
	
	private Node parent;
	private Node son;
	private Node temp;
	
	public BinaryTree(Data data){
		this.root = new Node(data);
		this.nodeCnt=0;
	}
	
	/**
	 * 이진트리에 노드를 추가하는 메소드
	 * 단, 추가하는 데이터가 기존 트리에 저장된 데이터와 중복되지 않는다고 가정
	 * @param data 노드에 추가할 데이터
	 */
	public void addNode(Data data){
		this.temp = this.getRoot();
		Node node = new Node(data);
		
		while(true){
			int res = this.compareDataWithNode(temp, node);
			if(res < 0){
				if(temp.getLeft()!=null){
					temp = temp.getLeft();
				}
				else{
					temp.setLeft(node);
					break;
				}
			}
			else{
				if(temp.getRight()!=null){
					temp = temp.getRight();
				}
				else{
					temp.setRight(node);
					break;
				}
			}
		}
		
	}
	
	public int compareDataWithNode(Node node1, Node node2){
		if(node1.getData().getIntData() > node2.getData().getIntData()){
			return -1;
		}
		else if(node1.getData().getIntData() < node2.getData().getIntData()){
			return 1;
		}
		else return 0;
	}
	
	public int compareDataWithData(Data data1, Data data2){
		if(data1.getIntData() > data2.getIntData()){
			return -1;
		}
		else if(data1.getIntData() < data2.getIntData()){
			return 1;
		}
		else return 0;
	}
	
	public void preOrder(Node node){
		if(node==null) return;
		this.printNodeData(node);
		this.preOrder(node.getLeft());
		this.preOrder(node.getRight());
	}
	
	public void inOrder(Node node){
		if(node==null) return;
		this.inOrder(node.getLeft());
		this.printNodeData(node);
		this.inOrder(node.getRight());
	}
	
	public void postOrder(Node node){
		if(node==null) return;
		this.postOrder(node.getLeft());
		this.postOrder(node.getRight());
		this.printNodeData(node);
	}
	
	/**
	 * C++과는 다르게 자기 자신을 삭제할 수 없으므로, 자식을 null로 셋팅함
	 * @param node 삭제할 기준이 되는 노드 
	 */
	public void postOrderDelete(Node node){
		if(node==null) return;
		this.postOrderDelete(node.getLeft());
//		System.out.println("데이터 "+node.getData().getIntData()+"인 노드를 삭제합니다.");
		node.setLeft(null); // 중복적으로 불리긴 하나 끝부터 지워지는 것은 맞음..
		this.postOrderDelete(node.getRight());
//		System.out.println("데이터 "+node.getData().getIntData()+"인 노드를 삭제합니다.");
		node.setRight(null); // 중복적으로 불리긴 하나 끝부터 지워지는 것은 맞음..
	}
	
	public void printNodeData(Node node){
		System.out.println("해당 노드의 데이터 : "+node.getData().getIntData());
	}

	public Node getRoot() {
		return root;
	}
	
	public Node searchNode(Data data){
		this.temp = this.root;
		
		while(true){
			int res = this.compareDataWithData(temp.getData(), data);
			
			if(res < 0){
				if(temp.getLeft()!=null){
					temp = temp.getLeft();
				}
				else{
					break;
				}
			}
			else if(res > 0){
				if(temp.getRight()!=null){
					temp = temp.getRight();
				}
				else{
					break;
				}
			}
			else{
				System.out.println("데이터 "+data.getIntData()+"에 해당하는 결과값을 찾았습니다!");
				return temp;
			}
		}
		
		System.out.println("데이터 "+data.getIntData()+"에 해당하는 결과값을 찾지 못했습니다.");
		return null;
	}
	
	public boolean destroy(){
		if(!this.root.hasChild()){
			System.out.println("삭제할 자식이 없습니다!");
			return false;
		}
		
		// 후위순회 순서대로 삭제(사실 셋팅을 null로 하는 것)
		this.postOrderDelete(this.root);
		return true;
	}
	
	// , , , , , deleteNode, , 
	/**
	 * 삭제하기
	 * 유형1) 삭제할 노드의 오른쪽 자식이 없는 경우
	 * ==> 삭제할 노드의 왼쪽 자식이 son 역할
	 * 유형2) 삭제할 노드의 오른쪽 자식의 왼쪽 자식이 없는 경우
	 * ==> 삭제할 노드의 오른쪽 자식이 son 역할
	 * 유형3) 그 외 모든 경우
	 * ==> 삭제한 노드의 오른쪽 서브트리에서 삭제할 데이터와 가장 가까운 값을 찾음
	 */
}
