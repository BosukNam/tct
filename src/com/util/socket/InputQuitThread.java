package com.util.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * QUIT 을 입력받으면 소켓통신을 종료하는 클래스 
 * @author nam
 */
public class InputQuitThread extends Thread {

	private ServerSocket listener;
	private Socket socket;

	public InputQuitThread(ServerSocket listener, Socket socket) {
		this.listener = listener;
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner scanner = null;
		String inputStr = null;

		do {
			System.out.print("Input 'QUIT' to stop server :: ");
			scanner = new Scanner(System.in);
			inputStr = scanner.next();
			System.out.println(inputStr);
		} while (!inputStr.equals("QUIT"));

		try {
			listener.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server closed...");
	}

}
