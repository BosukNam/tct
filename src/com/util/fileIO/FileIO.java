package com.util.fileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	public static void main(String[] args) {
		File inputFile = new File("./INPUT/INPUT.TXT");
		try {
			List<String> strList = new ArrayList<>();
			strList = readFile(inputFile, strList);
			File outputFile = new File("./OUTPUT/OUTPUT.TXT");
			if(!outputFile.exists()) outputFile.createNewFile();
			writeFile(outputFile,strList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile(File file, List<String> strList) throws IOException {
		PrintWriter writer = new PrintWriter(file);
		for(String line : strList) {
			writer.println(String.format("%s ",line));
		}
		writer.flush();
		writer.close();
	}

	public static List<String> readFile(File file, List<String> strList) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while(line!=null){
			System.out.println(line);
			strList.add(line);
			line = reader.readLine();
		}
		return strList;
	}

	public static void myCopyFile(String filename) {
		final int BUFFER_SIZE = 512;
		int readLen;

		try {
			// Create Folder
			File destFolder = new File("./OUTPUT");
			if (!destFolder.exists()) {
				destFolder.mkdirs();
			}

			// Copy File
			InputStream inputStream = new FileInputStream("./INPUT/" + filename);
			OutputStream outputStream = new FileOutputStream("./OUTPUT/" + filename);
			byte[] buffer = new byte[BUFFER_SIZE];

			while ((readLen = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, readLen);
			}

			inputStream.close();
			outputStream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
