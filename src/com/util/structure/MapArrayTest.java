package com.util.structure;

import java.util.*;
import java.util.stream.Collectors;

public class MapArrayTest {
    public static void main(String[] args) {

    }

    /**
     * Map 에 키 존재 때 작업
     * @param map
     * @param k
     */
    public void ifMapKeyPresent(Map<String, Integer> map, String k) {
        map.computeIfPresent(k, (String key, Integer value) -> ++value);
    }

    /**
     * Map 에 키 존재하지 않을 때 작업 (by function, by value)
     * @param map
     * @param key
     */
    public void ifMapKeyAbsent(Map<String, Integer> map, String key) {
        map.computeIfAbsent(key, x -> new Integer(0)); // by function
        map.putIfAbsent(key, 5); // by value
    }

    /**
     * 배열 채우기
     * @param ary
     */
    public void fillArray(int[] ary) {
        Arrays.fill(ary, 0);
    }

    /**
     * int[] 에서 찾는 값이 있는지 확인
     * @param ary
     * @param find
     * @return
     */
    public boolean anyMatchInIntAry(int[] ary, int find) {
        return Arrays.stream(ary).anyMatch(h -> h==find);
    }

    /**
     * List 를 Deque 로 변환 -> pollFirst, pollLast 가능
     * @param list
     * @return
     */
    public Deque listToDeque(List list) {
        return new ArrayDeque<>(list);
    }

    /**
     * List<Integer> 를 int[] 로 변환
     * @param intList
     * @return
     */
    public int[] integerListToIntAry(List<Integer> intList) {
        return intList.stream().mapToInt(x->x).toArray();
    }

    /**
     * int[] 를 List<Integer> 로 변환 + 내림차순 정렬
     * @param intAry
     * @return
     */
    public List<Integer> intAryToSortedList(int[] intAry) {
        List<Integer> result = intAryToList(intAry);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    /**
     * int[] 를 List<Integer> 로 변환
     * @param intAry
     * @return
     */
    public List<Integer> intAryToList(int[] intAry) {
        return Arrays.stream(intAry).boxed().collect(Collectors.toList());
    }

    /**
     * map의 value에 따라 내림차순으로 정렬. value가 같으면 key 오름찯순으로 정
     * @param map
     * @return
     */
    public List sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> result = new LinkedList<>(map.entrySet());
        Collections.sort(result, (o1, o2) -> o1.getValue()==o2.getValue() ?
                o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return result;
    }

    /**
     * String을 구성하는 문자들을 카운팅
     * @param map
     * @param line
     */
    public void makeStringCntMap(Map<String, Integer> map, String line) {
        for(String l : line.split("")) {
            map.put(l, map.getOrDefault(l, 0)+1);
        }
    }

    /**
     * map의 key와 value 출력
     * @param map
     */
    public void printMap(Map map) {
        map.keySet().forEach(key -> System.out.println(key + " :: " + map.get(key)));
    }
}
