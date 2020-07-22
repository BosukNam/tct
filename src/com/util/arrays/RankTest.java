package com.util.arrays;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class RankTest {
    public static void main(String[] args) {
        int[] scores = {100, 90, 90, 80, 75, 60};
        int[] alice = {50, 65, 77, 90, 102};
        for(int tmp : climbingLeaderboard(scores,alice)) {
            System.out.println(tmp);
        }
    }
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
        TreeSet<Integer> ts = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tmp : scores) ts.add(tmp);
        int ranking=ts.size();
        for(int tmp : ts) map.put(tmp,ranking--);

        int[] result = new int[alice.length];
        for(int i=0; i<result.length; i++) {
            int aliceScore = alice[i];
            int rank;
            if(ts.last()<aliceScore) {
                rank=1;
                result[i]=rank;
                continue;
            }
            if(ts.first()>aliceScore) {
                rank=ts.size()+1;
                result[i]=rank;
                continue;
            }
            result[i]=map.get(ts.floor(aliceScore));
        }
        return result;
    }
}
