package com.util.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtill {
	public static void main(String[] args) {
//		System.out.println(removeDupCharInStr("abbbbbbbbccccccccccc"));
//		System.out.println(removeDupCharInStr("aaaaadfasdfvvvccsssac"));
//		
//		System.out.println(removeDupCharWithNoInStr("abbbbbbbbccccccccccc"));
//		System.out.println(removeDupCharWithNoInStr("aaaaadfasdfvvvccsssac"));
//		
//		System.out.println(allCharInStrCnt("abbbbbbbbccccccccccc"));
//		System.out.println(allCharInStrCnt("aaaaadfasdfvvvccsssac"));
//
//		System.out.println(allCharInStrList("abbbbbbbbccccccccccc"));
//		System.out.println(allCharInStrList("aaaaadfasdfvvvccsssac"));
//		
//		String[] strAry = {"aaavvvccccc","ddddddddaaa"};
//		System.out.println(allCharInStrCnt(strAry));
//		System.out.println(allCharInStrList(strAry));
		
		
		String[][] cakeAry = {{"a","b","c","d","e"},{"a","b","c","d","e"},{"a","b","c","d","e"},{"a","b","c","d","e"},{"a","b","c","d","e"}};
		int[] rowAry = {1};
		int[] colAry = {2,3};
		strAryCake(cakeAry, rowAry, colAry);
	}

	/**
	 * 문자열에서 연속으로 중복인 글자 없애기
	 * @param originStr
	 * @return 
	 */
	public static String removeDupCharInStr(String originStr) {
		String result = "";
		result += originStr.charAt(0) + "";

		int index = 0;
		for (int i = 1; i < originStr.length(); i++) {
			if (!(result.charAt(index) + "").equals(originStr.charAt(i) + "")) {
				result += originStr.charAt(i) + "";
				index++;
			} else {

			}
		}
		return result;
	}
	
	/**
	 * 문자열에서 연속으로 중복인 글자 숫자까지 표시
	 * @param originStr
	 * @return 
	 */
	public static String removeDupCharWithNoInStr(String originStr) {
		String result = "";
		result += originStr.charAt(0) + "";

		int index = 0;
		int cnt = 1;
		for (int i = 1; i < originStr.length(); i++) {
			if (!(result.charAt(index) + "").equals(originStr.charAt(i) + "")) {
				if(cnt!=1) {
					result += cnt;
					cnt = 1;
					index++;
				}
				result += originStr.charAt(i) + "";
				index++;
			} else {
				cnt++;
			}
		}
		if(cnt!=1) {
			result += cnt;
		}
		return result;
	}
	
	/**
	 * 문자열 전체에서 중복되지 않은 글자 List 리턴
	 * @param originStr
	 * @return 노중복글자 리스트
	 */
	public static List<String> allCharInStrList(String originStr) {
		List<String> strList = new ArrayList<>();
		Set<Character> chSet = new HashSet<>();
		char[] chAry = originStr.toCharArray();
		for(char ch : chAry) {		
			if(!chSet.contains(ch)) {
				chSet.add(ch);
				strList.add(ch+"");
			}
		}
		return strList;
	}
	

	/**
	 * 문자열 배열 전체에서 중복되지 않은 글자 List 리턴
	 * @param originStrAry
	 * @return 노중복글자 리스트
	 */
	public static List<String> allCharInStrList(String[] originStrAry) {
		List<String> strList = new ArrayList<>();
		Set<Character> chSet = new HashSet<>();
		for(String line : originStrAry) {
			char[] chAry = line.toCharArray();
			for(char ch : chAry) {		
				if(!chSet.contains(ch)) {
					chSet.add(ch);
					strList.add(ch+"");
				}
			}
		}
		return strList;
	}
	
	/**
	 * 문자열 전체에서 중복되지 않은 글자 갯수 리턴
	 * @param originStr
	 * @return 노중복글자 수 
	 */
	public static int allCharInStrCnt(String originStr) {
		Set<Character> chSet = new HashSet<>();
		char[] chAry = originStr.toCharArray();
		for(char ch : chAry) {			
			chSet.add(ch);
		}
		return chSet.size();
	}
	
	/**
	 * 문자열 배열 전체에서 중복되지 않은 글자 갯수 리턴
	 * @param originStrAry
	 * @return 노중복글자 수 
	 */
	public static int allCharInStrCnt(String[] originStrAry) {
		Set<Character> chSet = new HashSet<>();
		for(String line : originStrAry) {
			char[] chAry = line.toCharArray();
			for(char ch : chAry) {			
				chSet.add(ch);
			}
		}
		return chSet.size();
	}
	
	/**
	 * String 글자로 구성된 NxN 배열의 케익이 있다.
	 * 해당 케익을 가로, 세로로 잘랐을 때 
	 * 중복없이 가장 많은 글자를 가진 케익조각의 글자수는? 
	 * 
	 * @param strDblAry NxN의 2차원 배열
	 * @param row 케익을 가로로 자르는 위치
	 * @param col 케익을 세로로 자르는 위치
	 * @return 케익조각 위에 있는 글자 갯수 (중복없이) => 예외처리 -1
	 */
	public static int strAryCake(String[][] strDblAry, int[] rowAry, int[] colAry) {
		// 예외처리
		if(strDblAry==null || rowAry==null || rowAry==null || 
				rowAry.length<1 || rowAry.length<1) return -1;
					
		int maxCnt = 0;
		int nSize = strDblAry.length;
		
		// 예외처리
		if(nSize<=1 || nSize != strDblAry[0].length 
				|| rowAry.length>=nSize || colAry.length>=nSize) return -1;
		
		for(int row: rowAry) {
			if(row<1 || row>=nSize) return -1;
		}
		for(int col: colAry) {
			if(col<1 || col>=nSize) return -1;
		}
		
		// 케익 가로 자르기
		int rowCutCnt = 0;
		for(int i=0; i<nSize; i++) {
			int cutRow = rowAry[rowCutCnt];
			if(i<cutRow) {
				System.out.print(i + " ");
			} else {
				rowCutCnt++;
			}
			System.out.println();
			
		}
		
		return -1;
	}
}
