package com.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestServer {

	public static List<String> inputStringList = Collections.synchronizedList(new ArrayList<String>());
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		int portNo = 9876;

		try {
			listener = new ServerSocket(portNo);
			System.out.println("Server start...");
			
			while(!(socket = listener.accept()).isClosed()) {
				System.out.println("Server accepted client...");
				TestInputThread inputThread = new TestInputThread(listener, socket);
				inputThread.start();
			}
		} catch (SocketException ex) {
			System.out.println("ServerSocket closed...");
		} catch (IOException ex) {
			System.out.println("Can't setup server on this port number. ");
		}

	}
}
