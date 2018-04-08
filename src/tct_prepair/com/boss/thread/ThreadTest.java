package tct_prepair.com.boss.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {

		/////////////////////////////////// Thread ///////////////////////////////////////
		int i = 0;
		MyThread tclass1 = new MyThread(i, "Thread1");
		MyThread tclass2 = new MyThread(i, "Thread2");

		Thread t1 = new Thread(tclass1);
		Thread t2 = new Thread(tclass2);

		t1.start();
		t2.start();

		while (i < 30) {
			System.out.println("[Main] " + i++);
		}

		//////////////////////////////////// Mutex Thread ///////////////////////////////////////

		i = 0;
		MyMutexThread tmclass1 = new MyMutexThread(i, "Thread1");
		MyMutexThread tmclass2 = new MyMutexThread(i, "Thread2");

		Thread tm1 = new Thread(tmclass1);
		Thread tm2 = new Thread(tmclass2);

		tm1.start();
		tm2.start();

		// join 구문이 없으면 main 스레드와 엉킬 수 있음
		try {
			tm1.join();
			tm2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lock.lock();
		System.out.println("[Main] ");
		while (i < 30) {
			System.out.print(i++ + " ");
		}

		System.out.println();
		lock.unlock();
	}

}