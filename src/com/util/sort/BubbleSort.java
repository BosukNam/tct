package com.util.sort;

import java.util.List;

public class BubbleSort {
	public static void main(String[] args) {
		List<Integer> intList = CommonUtil.randomIntListMaker(10);
		System.out.println("before sort :: " + intList);
		
		bubbleSort(intList);
		System.out.println("after sort :: " + intList);
	}

	
	public static void bubbleSort(List<Integer> intList){
		for(int i=0; i<intList.size()-1; i++){
			for(int j=0; j<intList.size()-i-1; j++){
				if(intList.get(j) > intList.get(j+1)){
					Integer tmp = new Integer(intList.get(j+1));
					intList.set(j+1, intList.get(j));
					intList.set(j, tmp);
				}
			}
		}
	}

}
