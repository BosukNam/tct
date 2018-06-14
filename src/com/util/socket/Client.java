package com.util.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			fileSend("127.0.0.1", 9090);
		} catch (IOException e) {
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
