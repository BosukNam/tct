package com.util.socket;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		int portNo = 9090;

		try {
			listener = new ServerSocket(portNo);
			System.out.println("Server start...");
		} catch (IOException ex) {
			System.out.println("Can't setup server on this port number. ");
		}

		try {
			while((socket = listener.accept()) != null) {
				System.out.println("Server accepted client...");
				InputThread inputThread = new InputThread(listener, socket);
				inputThread.start();
			}
		} catch (IOException ex) {
			System.out.println("Client connection has been closed...");
		}

	}

	/**
	 * 해당 경로로 파일을 다운받는 메소드
	 * 
	 * @param socket
	 *            accept 받은 소켓 정보
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	static void fileReceive(Socket socket) throws UnknownHostException, IOException {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = socket.getInputStream();
		} catch (IOException ex) {
			System.out.println("Can't get socket input stream. ");
		}

		try {
			// out = new FileOutputStream("./receive/oraociei12.dll");
			out = new FileOutputStream("path/file-name");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found. ");
		}

		byte[] bytes = new byte[16 * 1024];
		int count;

		while ((count = in.read(bytes)) > 0) {
			out.write(bytes, 0, count);
		}

		out.close();
		in.close();
	}
}
