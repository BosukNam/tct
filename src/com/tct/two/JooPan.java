package com.tct.two;

/**
 * TCT 2번 문제
 * @author nam
 * 
 * 주판 계산에 대한 로직이 작성되어 있는데 오류가 2가지 있음 (사실 1가지로 판명됨)
 * 1. 주판 계산 오류를 찾아 고치시오 (없었음)
 * 2. 주판 2개의 합을 구하는 과정에서의 오류를 찾아 고치시오
 */
public class JooPan {
	public static void main(String[] args) {
		/*
		 25,479 를 주판으로 표현하기
		 up    0 1 0 1 1
		 down  1 0 1 1 1
		       1 0 1 1 1
		       0 0 1 0 1
		       0 0 1 0 1
		 */
		
		// 아무튼 up = num /5; down = num/5; 로 되어있는 부분을
		// down = num%5; 로 바꾸면 해결됨
	}
}
