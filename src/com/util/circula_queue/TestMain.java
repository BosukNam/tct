package com.util.circula_queue;

public class TestMain {
	public static void main(String[] args){
		CirculaQueue queue = new CirculaQueue(5);
		
		/** 초기 원형 큐의 상태 확인 */
		queue.displayQueue();
//		queue.dequque();
//		queue.isQueueEmpty();
		
		/** 원형 큐에 데이터 추가 */
		queue.enqueue(new Data(4));
		queue.enqueue(new Data(5));
		queue.enqueue(new Data(1));
		queue.enqueue(new Data(2));
		queue.enqueue(new Data(3)); // 큐가 꽉 차서 데이터 추가 실패
		queue.displayQueue();
		
		/** 원형 큐에서 데이터 추출 */
		queue.dequque();
		queue.dequque();
		queue.dequque();
		queue.displayQueue();
		
		/** 원형 큐에 데이터 추가,추출 반복 */
		queue.enqueue(new Data(7));
		queue.enqueue(new Data(6));
		queue.enqueue(new Data(3));
		queue.displayQueue();
		queue.dequque();
		queue.dequque();
		queue.dequque();
		queue.displayQueue();
		queue.enqueue(new Data(7));
		queue.enqueue(new Data(6));
		queue.enqueue(new Data(3));
		queue.displayQueue();
		queue.dequque();
		queue.dequque();
		queue.dequque();
		queue.displayQueue();
	}
}
