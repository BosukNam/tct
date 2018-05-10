package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonUtil {

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
