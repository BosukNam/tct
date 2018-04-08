package single_linkedList;

public class TestMain {
	public static void main(String[] args){
		SingleLinkedList sList = new SingleLinkedList();
		
		// 저장된 노드가 없는 경우
		sList.display(); 
		
		// 노드 1개 추가
		sList.addNode(new Data(10));
		sList.display();
		
		// 노드 3개 추가
		sList.addNode(new Data(5));
		sList.addNode(new Data(7));
		sList.addNode(new Data(3));
		sList.display(); 
		
		// 마지막으로 추가된 노드 삭제
		sList.removeLastNode();
		sList.display(); 
		
		// 마지막으로 추가된 노드 2개 삭제
		sList.removeLastNode();
		sList.removeLastNode();
		sList.display(); 
		
		// 노드 4개 추가 후, 저장된 모든 노드 삭제
		sList.addNode(new Data(2));
		sList.addNode(new Data(3));
		sList.addNode(new Data(4));
		sList.addNode(new Data(5));
		sList.display();
		sList.removeAllNode();
		sList.display(); 
		
		// 단일 노드 검색, 다중 노드 검색
		sList.addNode(new Data(2));
		sList.addNode(new Data(3));
		sList.addNode(new Data(4));
		sList.addNode(new Data(5));
		sList.addNode(new Data(2));
		sList.addNode(new Data(3));
		sList.addNode(new Data(4));
		sList.addNode(new Data(5));
		sList.addNode(new Data(4));
		sList.addNode(new Data(4));
		sList.searchData(new Data(4));
		sList.searchDuplicatedData(new Data(4));
		sList.searchDuplicatedData(new Data(14));
		
	}
}
