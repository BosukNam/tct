package com.util.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client가 연결되었을 때 스트림으로 입력값을 출력하는 클래스 
 * @author nam
 */
public class InputThread extends Thread {

	private ServerSocket listener;
	private Socket socket;

	public InputThread(ServerSocket listener, Socket socket) {
		this.listener = listener;
		this.socket = socket;
	}

	@Override
	public void run() {
//		Scanner scanner = new Scanner(System.in);
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println("client >> " + line);
				if(line.equals("exit")) {
					break;
				}
			}
//			scanner.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			listener.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server closed...");
	}

}
