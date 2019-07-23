package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) {
		Socket socket = new Socket();
		Scanner sc = new Scanner(System.in);
		int portNo = 9876;

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		OutputStream os = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;

		try {
			socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), portNo));
			System.out.println("[client] connected with server");
		
			while(true) {
				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os, "UTF-8");
				pw = new PrintWriter(osw, true);
				
				is = socket.getInputStream();
				isr = new InputStreamReader(is, "UTF-8");
				br = new BufferedReader(isr);
				
				System.out.print(">>");
				String data = sc.nextLine();
				
				if("exit".equals(data))
					break;
				
				pw.println(data);
				
				data = br.readLine();
				System.out.println("<< " + data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sc.close();
		}
	}
}
