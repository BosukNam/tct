package tct_prepair.com.boss.fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	public static void main(String[] args) {
		File directory = new File("./INPUT");
		// get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList) {
			System.out.println(file.getName() + ":	" + file.length() + "bytes");
			if (file.length() > 2048) {
				MyCopyFile(file.getName());
			}
		}
	}
	
	static void MyCopyFile(String filename) {
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
