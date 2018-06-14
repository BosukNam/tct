package com.util.binary_tree;

public class TestMain {
	public static void main(String[] args){
		BinaryTree myTree = new BinaryTree(new Data(6));
		
		/** 초기 이진트리 */
//		myTree.inOrder(myTree.getRoot());
		
		/** 전위,중위,후위순회 결과값 확인 */
		myTree.addNode(new Data(3));
		myTree.addNode(new Data(4));
		myTree.addNode(new Data(8));
		myTree.addNode(new Data(9));
		myTree.addNode(new Data(1));
		System.out.println("*** 전위순회 결과값 ***");
		myTree.preOrder(myTree.getRoot()); // 전위순회 (노드 -> 왼쪽 -> 오른쪽)
		System.out.println("*** 중위순회 결과값 (정렬된 결과값이 나옵니다) ***");
		myTree.inOrder(myTree.getRoot()); // 중위순회 (왼쪽 -> 노드 -> 오른쪽)
		System.out.println("*** 후위순회 결과값 (destroy할 순서에 적합한 결과값이 나옵니다) ***");
		myTree.postOrder(myTree.getRoot()); // 후위순회 (왼쪽 -> 오른쪽 -> 노드)
		
		/** 이진트리 데이터 검색 */
		myTree.searchNode(new Data(4));
		
		
		/** 이진트리 전체 삭제(루트 제외) */
		myTree.destroy();
		myTree.inOrder(myTree.getRoot());
		myTree.destroy();
		myTree.inOrder(myTree.getRoot());
	}
}
