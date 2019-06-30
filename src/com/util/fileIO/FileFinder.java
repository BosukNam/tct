package com.util.fileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileFinder {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input file name >> ");
		String inputStr = scanner.nextLine();
		File rootFile = new File("./INPUT");
		findFile(rootFile, inputStr);
		scanner.close();
		
		
	}
	
	public static void findFile(File rootFile, String fileName) {
		if(rootFile.exists()) {
			// get all the files from a directory
			File[] fList = rootFile.listFiles();
			for (File file : fList) {
				if(file.isDirectory()) {
					System.out.println("Folder >> " + file.getName());
					findFile(file, fileName);
				} else {
					// TO DO : logic of equals fileName or something
					try {
						System.out.println("File >> " + file.getName()
						+ "(" + file.getCanonicalPath() + ")");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		

	}
}
