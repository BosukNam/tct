package com.tct.four;

import java.util.ArrayList;
import java.util.List;

/**
 * TCT 4번 문제
 * @author nam
 * 
 * 1. 일렬로 된 숫자 String 중 3번 이상 연속된 숫자를 0 으로 바꾸기
 * 2. 일렬로 된 숫자 String을 n*n의 행렬로 만들어 집어넣고, 남은 숫자는 버리기 
 * 3. 2번에서 만든 n*n 행렬에서 가로 혹은 세로로 3번 이상 연속된 숫자를 0으로 바꾸기
 *  
 */
public class ChangeContinuosNumber {
	public static void main(String[] args) {
		List<List<Integer>> totalIntegerList = makeSampleIntegerList();
		
		int[][] intDoubleAry = makeIntegerDoubleListToIntDoubleAry(totalIntegerList);
		int[][] copyAry = makeIntegerDoubleListToIntDoubleAry(totalIntegerList);
		
		printDoubleAry(copyAry, "orginal array");
		
		// 가로 방향으로 연속 3자리이면 0으로 바꾸기
		for(int i=0; i<intDoubleAry.length; i++){
			for(int j=0; j<intDoubleAry[i].length-2; j++){
				int currentNum = copyAry[i][j];
				if(currentNum == copyAry[i][j+1] && currentNum == copyAry[i][j+2]){
					intDoubleAry[i][j] = 0;
					intDoubleAry[i][j+1] = 0;
					intDoubleAry[i][j+2] = 0;
				}
			}
		}
	
		// 세로 방향으로 연속 3자리이면 0으로 바꾸기
		for(int i=0; i<intDoubleAry.length-2; i++){
			for(int j=0; j<intDoubleAry[i].length; j++){
				int currentNum = copyAry[i][j];
				if(currentNum == copyAry[i+1][j] && currentNum == copyAry[i+2][j]){
					intDoubleAry[i][j] = 0;
					intDoubleAry[i+1][j] = 0;
					intDoubleAry[i+2][j] = 0;
				}
			}
		}
		
		printDoubleAry(intDoubleAry, "changed array");
	}
	
	public static void printDoubleList(List<List<Integer>> doubleList, String title){
		System.out.println("******** "+title+" *********");
		for(List<Integer> row : doubleList){
			for(Integer tmp : row){
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
	}
	
	public static void printDoubleAry(int[][] doubleAry, String title){
		System.out.println("******** "+title+" *********");
		for(int j=0; j<doubleAry.length; j++){
			for(int i=0; i<doubleAry[j].length; i++){
				System.out.print(doubleAry[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> makeIntDoubleAryToIntegerDoubleList(int[][] intDoubleAry){
		List<List<Integer>> totalIntegerList = new ArrayList<>();
		
		for(int j=0; j<intDoubleAry.length; j++){
			List<Integer> rowList = new ArrayList<>();
			for(int i=0; i<intDoubleAry[j].length; i++){
				rowList.add(new Integer(intDoubleAry[j][i]));
			}
			totalIntegerList.add(rowList);
		}
		
		return totalIntegerList;
	}
	
	public static int[][] makeIntegerDoubleListToIntDoubleAry(List<List<Integer>> integerDoubleList){
		int rowSize = integerDoubleList.size();
		int[][] intDoubleAry = new int[rowSize][rowSize];
		
		for(int j=0; j<rowSize; j++){
			List<Integer> row = integerDoubleList.get(j);
			for(int i=0; i<rowSize; i++){
				Integer tmp = row.get(i);
				intDoubleAry[j][i] = tmp;
			}
		}
		
		return intDoubleAry;
	}
	
	public static List<List<Integer>> makeSampleIntegerList() {
		
		/*
		6 7 4 3 9
		1 3 2 4 8
		1 1 1 4 8
		1 9 7 4 8
		2 7 8 8 8
		*/
		List<List<Integer>> totalIntegerList = new ArrayList<>();
		
		List<Integer> rowList = new ArrayList<>();
		rowList.add(new Integer(6));
		rowList.add(new Integer(7));
		rowList.add(new Integer(4));
		rowList.add(new Integer(3));
		rowList.add(new Integer(9));
		totalIntegerList.add(rowList);
		
		rowList = new ArrayList<>();
		rowList.add(new Integer(1));
		rowList.add(new Integer(3));
		rowList.add(new Integer(2));
		rowList.add(new Integer(4));
		rowList.add(new Integer(8));
		totalIntegerList.add(rowList);
		
		rowList = new ArrayList<>();
		rowList.add(new Integer(1));
		rowList.add(new Integer(1));
		rowList.add(new Integer(1));
		rowList.add(new Integer(4));
		rowList.add(new Integer(8));
		totalIntegerList.add(rowList);
		
		rowList = new ArrayList<>();
		rowList.add(new Integer(1));
		rowList.add(new Integer(9));
		rowList.add(new Integer(7));
		rowList.add(new Integer(4));
		rowList.add(new Integer(8));
		totalIntegerList.add(rowList);
		
		rowList = new ArrayList<>();
		rowList.add(new Integer(2));
		rowList.add(new Integer(7));
		rowList.add(new Integer(8));
		rowList.add(new Integer(8));
		rowList.add(new Integer(8));
		totalIntegerList.add(rowList);
		
		return totalIntegerList;
	}
}
