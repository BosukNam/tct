package sort;

import java.util.List;

public class SelectionSort {
	public static void main(String[] args) {
		List<Integer> intList = CommonUtil.randomIntListMaker(10);
		System.out.println("before sort :: " + intList);
		
		selectionSort(intList);
		System.out.println("after sort :: " + intList);
	}
	
	public static void selectionSort(List<Integer> intList){
		for(int i=0; i<intList.size()-1; i++){
			int min = i;
			for(int j=i+1; j<intList.size(); j++){
				if(intList.get(min) > intList.get(j)){
					min = j;
				}
			}
			if(min != i){
				Integer tmp = new Integer(intList.get(min));
				intList.set(min, intList.get(i));
				intList.set(i, tmp);
			}
		}
	}
	
}
