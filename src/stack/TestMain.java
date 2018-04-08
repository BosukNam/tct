package stack;

public class TestMain {
	public static void main(String[] args){
	
		ArrayStack stack = new ArrayStack(5);
		
		/** 초기 스택 상태 확인 */
		stack.printStack();
//		stack.clearStack();
//		stack.popStack();
		
		/** 스택에 데이터 추가 */
		stack.pushStack(new Data(1));
		stack.pushStack(new Data(3));
		stack.pushStack(new Data(7));
		stack.printStack();
		
		/** 스택에서 데이터 추출 */
		stack.popStack();
		stack.popStack();
		stack.printStack();
		
		/** 스택에 저장된 모든 값 삭제 */
		stack.pushStack(new Data(1));
		stack.pushStack(new Data(3));
		stack.pushStack(new Data(7));
		stack.clearStack();
		stack.printStack();
		
	}
}
