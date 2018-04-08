package tct_prepair.com.boss.thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyMutexThread implements Runnable{
	private int num;
	private String threadName;
	static ReentrantLock lock = new ReentrantLock();
	
	public MyMutexThread(int num, String threadName){
		this.num = num;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println("[" + threadName + "] ");
		for (int i = num; i < 30; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		lock.unlock();
	}
}
