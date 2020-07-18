package com.util.fileIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExecuteEx {
    public static void main(String[] args) {

    	/* Under Java 1.4 
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

		try {
			// run win32 exe
			process = runtime.exec("C:\\Program Files(x86)\\Microsoft Office\\Office14\\EXCEL.EXE");
			process = runtime.exec("cmd /c dir /?");
		} catch (IOException e) {
			System.out.println("file not");
		} finally {
			// process.waitFor();
			// process.destroy();
		}
		*/

        /* Over Java 1.5 */
    	String s;
        try {
            Process oProcess = new ProcessBuilder("cmd", "/c", "dir", "/?").start();
            
            // read external program OUT, ERR
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
            
            while((s = stdOut.readLine())!=null) System.out.println(s);
            while((s = stdError.readLine())!=null) System.err.println(s);
            
            System.out.println("Exit Code: " + oProcess.exitValue());
            System.exit(oProcess.exitValue());
        }
        catch(IOException e){
            System.err.println("Error! Fail to run external program!");
            System.exit(-1);
        }
    }
}