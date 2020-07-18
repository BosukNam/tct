package com.util.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtill {
	public static void main(String[] args) {
		System.out.println(removeDupCharInStr("abbbbbbbbccccccccccc"));
		// abc

		System.out.println(removeDupCharWithNoInStr("abbbbbbbbccccccccccc"));
		// ab8c11

		System.out.println(allCharInStrCnt("abbbbbbbbccccccccccc"));
		// 3

		System.out.println(allCharInStrList("abbbbbbbbccccccccccc"));
		// [a, b, c]

		String[] strAry = {"aaavvvccccc","ddddddddaaa"};
		System.out.println(allCharInStrCnt(strAry)); // 4
		System.out.println(allCharInStrList(strAry));// [a, v, c, d]
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
}
