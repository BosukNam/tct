package com.tct.sp;

import java.io.File;
import java.util.Scanner;

/**
 * TCT System & Soulution Programing 기출문제(2018년 초) 풀이
 * 1. 파일명 입력+검색
 * 2. 해당 파일 내용 암호화 (연속 세자리 이상 바꾸기 AAA->000)
 * 3. 해당 파일 웹소켓 전송 (복사)
 * @author nam
 */
public class FileTransferProgram {

	public static void main(String[] args) {

		int selectedMenuNo = -1;
		
		do{
			selectedMenuNo = selectMainMenu();
			
			switch (selectedMenuNo) {
			case 1:
				searchFile();
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4: break;
			default:
				System.out.println("# 존재하지 않는 메뉴입니다! 다시 입력해주세요!!\n");
			}
			
		}while(selectedMenuNo != 4);
	
		System.out.println("# 프로그램을 종료합니다...");
	}

	public static void searchFile() {
		Scanner scanner = new Scanner(System.in);
		String inputStr = null;
		boolean isNameCorrectlyInputed = false;
		
		do {
			System.out.println("\n################## 파일 찾기 ###################");
			System.out.print(">>파일명을 입력하세요 : ");
			inputStr = scanner.nextLine();
			
			if (inputStr == null || inputStr.length() == 0) 
				System.out.println("# 잘못된 입력입니다! 다시 입력해주세요!!\n");
			else
				isNameCorrectlyInputed = true;

		} while (!isNameCorrectlyInputed);
		
		
		boolean isFileExists = false;
		File directory = new File("./");
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if(file.isFile() && file.getName().equals(inputStr.trim())) {
				System.out.println(file.getName() + ":	" + file.length() + "bytes\n");
				isFileExists = true;
			} 
		}
		
		if(!isFileExists)
			System.out.println("# 파일이 존재하지 않습니다.\n");
	}
	
	public static int selectMainMenu() {
		Scanner scanner = new Scanner(System.in);
		String selectedMenuStr = null;
		boolean isMenuSelected = false;
		int selectedMenuNo = -1;
		
		do {
			System.out.println("############### 파일 전송 프로그램 ################");
			System.out.println("1. " + "파일 찾기");
			System.out.println("2. " + "파일 암호화");
			System.out.println("3. " + "파일 전송");
			System.out.println("4. " + "프로그램 종료");
			System.out.println("##############################################");
			System.out.print("메뉴를 입력하세요 : ");
			selectedMenuStr = scanner.nextLine();
			
			if (selectedMenuStr != null && selectedMenuStr.length() > 0) {
				try {
					selectedMenuNo = Integer.parseInt(selectedMenuStr);
					isMenuSelected = true;
				} catch (Exception e) {
					System.out.println("# 잘못된 입력입니다! 다시 입력해주세요!!\n");
				}
			} else
				System.out.println("# 잘못된 입력입니다! 다시 입력해주세요!!\n");

		} while (!isMenuSelected);
		
		return selectedMenuNo;
	}
}
