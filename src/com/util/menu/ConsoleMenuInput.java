package com.util.menu;

import java.util.Scanner;

public class ConsoleMenuInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String selectedMenu = null;
		do{
			printMenu();
			selectedMenu = scanner.nextLine();
		}while(selectedMenu != null && Integer.parseInt(selectedMenu) != 6);
	}

	public static void printMenu() {
		System.out.println("##############################################");
		System.out.println("1. " + "First Menu");
		System.out.println("2. " + "Second Menu");
		System.out.println("3. " + "Third Menu");
		System.out.println("4. " + "Fourth Menu");
		System.out.println("5. " + "Fifth Menu");
		System.out.println("6. " + "Exit");
		System.out.println("##############################################");
		System.out.print("Select : ");
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
					System.out.println("# 잘못된 입력입니다! 다시 입력해주세요!!");
				}
			} else
				System.out.println("# 잘못된 입력입니다! 다시 입력해주세요!!");

		} while (!isMenuSelected);
		
		return selectedMenuNo;
	}
}
