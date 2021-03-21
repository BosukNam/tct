package com.util.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveCase {
    public static void main(String[] args) {
        // all cases
        int[] array = new int[]{1,2,3,4,5};
        List<List<Integer>> dCases = new ArrayList<>();
        boolean[] check = new boolean[5];
        int[] output = new int[5];
        allPermutation(array,output,0,array.length,dCases);
        System.out.println(dCases.size());
        for(List<Integer> tmp : dCases) {
            printIntList(tmp);
        }

        //distinct cases
        int[] array2 = new int[]{1,2,3,4,5};
        List<List<Integer>> dCases2 = new ArrayList<>();
        boolean[] check2 = new boolean[5];
        int[] output2 = new int[5];
        distinctPermutation(array2, output2, check2, 0, array2.length, array2.length, dCases2);
        System.out.println(dCases2.size());
        for(List<Integer> tmp : dCases2) {
            printIntList(tmp);
        }
    }

    public static void printIntList(List<Integer> list) {
        for(int tmp : list) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void printIntAry(int[] ary) {
        for(int tmp : ary) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void distinctPermutation(int[] array, int[] output, boolean[] isVisit, int depth, int length, int count, List<List<Integer>> allCases) {
        if(count==0) {
            List<Integer> outputList = Arrays.stream(output).boxed().collect(Collectors.toList());
            allCases.add(outputList);
            return;
        }
        for(int i=0; i<length; i++) {
            if(isVisit[i]!=true) {
                isVisit[i] = true;
                output[depth] = array[i];
                distinctPermutation(array, output, isVisit, depth+1, length, count-1,allCases);
                isVisit[i] = false;
            }
        }
    }

    public static void allPermutation(int[] array, int[] output, int depth, int count, List<List<Integer>> allCases) {
        if (count == 0) {
            List<Integer> outputList = Arrays.stream(output).boxed().collect(Collectors.toList());
            allCases.add(outputList);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            output[depth] = array[i];
            allPermutation(array, output, depth + 1, count - 1, allCases);
        }
    }
}
