package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestMain {
	
	public static Map<String,List<String>> memberMap = Collections.synchronizedMap(new HashMap<>());
	
	public static void main(String[] args) {
		/* Read File*/
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input file name >> ");
		String inputStr = scanner.nextLine();
		File rootFile = new File("./INPUT");
		findAndReadFile(rootFile, inputStr);
		scanner.close();
		
		/* print key-value map */
		Iterator<String> itr = memberMap.keySet().iterator();
		synchronized (memberMap) {
			while(itr.hasNext()) {
				String key = itr.next();
				System.out.println(key + " : " + memberMap.get(key));
			}
		}
		
		/* run exe */
		Set<String> keys = memberMap.keySet();
		for(String key : keys) {
			processExecute("paht/abc.exe", key + " parameters");
		}
	}
	
	public static void findAndReadFile(File rootFile, String fileName) {
		if(rootFile.exists()) {
			// get all the files from a directory
			File[] fList = rootFile.listFiles();
			for (File file : fList) {
				if(file.isDirectory()) {
					System.out.println("Folder >> " + file.getName());
					findAndReadFile(file, fileName);
				} else {
					// TO DO : logic of equals fileName or something
					try {
						System.out.println("File >> " + file.getName() + "(" + file.getCanonicalPath() + ")");
						if(file.getName().equals(fileName)) {
							BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
							
							String line = null;
							while(!(line = reader.readLine()).equals("PRINT")) {
								if(!line.contains(":")) {
									String[] tmps = line.split(",");
									for(int i=0; i<tmps.length; i++) {
										memberMap.put(tmps[i], Collections.synchronizedList(new ArrayList<String>()));
									}
								} else {
									String memberName = line.substring(0, line.indexOf(":"));
									List<String> list = memberMap.get(memberName);
									String memberValue = line.substring(line.indexOf(":")+1);
									String[] memberValues = memberValue.split(",");
									for(int i=0; i<memberValues.length; i++) {
										list.add(memberValues[i]);
									}
								}
							}
							reader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void processExecute(String filePath, String command){
        /* Over Java 1.5 */
    	String s;
        try {
            Process oProcess = new ProcessBuilder(filePath, command).start();
            
            // read external program OUT, ERR
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
            
            while((s = stdOut.readLine())!=null) System.out.println(s);
            while((s = stdError.readLine())!=null) System.out.println(s);
            
            System.out.println("Exit Code: " + oProcess.exitValue());
            System.exit(oProcess.exitValue());
        }
        catch(IOException e){
            System.err.println("Error! Fail to run external program!");
            System.exit(-1);
        }
	}
}
