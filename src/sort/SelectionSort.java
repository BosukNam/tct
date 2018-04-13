package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionSort {
	public static void main(String[] args) {
		List<Integer> intList = randomIntListMaker(10);
		System.out.println("before sort :: " + intList);
		
		selectionSort(intList);
		System.out.println("after sort :: " + intList);
	}
	
	public static List<Integer> selectionSort(List<Integer> intList){
		List<Integer> sortedList = new ArrayList<>();
		
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
		
		return null;
	}
	
	public static List<Integer> randomIntListMaker(int bound){
		List<Integer> intList = new ArrayList<>();
		
		Random rand = new Random();
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		intList.add(new Integer(rand.nextInt(bound)));
		
		return intList;
	}
}
