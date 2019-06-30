package com.util.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner scanner = new Scanner(System.in);
			String inputStr = null;
			
			do {
				System.out.print("input >> ");
				inputStr = scanner.nextLine();
				writer.println(inputStr);
				writer.flush();
			}
			while(!inputStr.equals("exit"));
			scanner.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 폴더에 있는 파일을 OutputStream으로 전송하는 메소드
	 * @param server 서버주소
	 * @param port 포트
	 * @throws IOException
	 */
	public static void fileSend(String server, int port) throws IOException {
		Socket socket = null;
		socket = new Socket(server, port);

//		File file = new File("./send/oraociei12.dll");
		File file = new File("path/file-name");

		// Get the size of the file
		long length = file.length();
		byte[] bytes = new byte[16 * 1024];
		InputStream in = new FileInputStream(file);
		OutputStream out = socket.getOutputStream();

		int count;
		while ((count = in.read(bytes)) > 0) {
			out.write(bytes, 0, count);
		}

		out.close();
		in.close();
		socket.close();
	}

}
