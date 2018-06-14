package com.util.thread;

public class MyThread implements Runnable {
	private int num;
	private String threadName;

	public MyThread(int num, String threadName) {
		this.num = num;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for (int i = num; i < 30; i++) {
			System.out.println("[" + threadName + "] " + i);
		}
	}
}
