package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

/**
 * Client가 연결되었을 때 스트림으로 입력값을 출력하는 클래스 
 * @author nam
 */
public class TestInputThread extends Thread {

	private ServerSocket listener;
	private Socket socket;

	public TestInputThread(ServerSocket listener, Socket socket) {
		this.listener = listener;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			OutputStream os = null;
			OutputStreamWriter osw = null;
			PrintWriter pw = null;
			
			while (true) {
				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os, "UTF-8");
				pw = new PrintWriter(osw, true);
				
				is = socket.getInputStream();
				isr = new InputStreamReader(is, "UTF-8");
				br = new BufferedReader(isr);
				
				String buffer = null;
				buffer = br.readLine();
				if(buffer == null) {
					System.out.println("[server] closed by client (" + this.getId() +  ")");
					break;
				}
				
				System.out.println("[server] received : "+buffer);
				pw.println(buffer);
				
				if(buffer.equals("PRINT")) {
					synchronized (TestServer.inputStringList) {
						Iterator<String> iterator = TestServer.inputStringList.iterator();
						while(iterator.hasNext())
							System.out.println(iterator.next());
					}
					
					System.exit(1);
					socket.close();
					listener.close();
				} else {
					TestServer.inputStringList.add(buffer);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			listener.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
