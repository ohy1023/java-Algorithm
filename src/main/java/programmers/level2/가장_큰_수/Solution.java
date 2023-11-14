package programmers.level2.가장_큰_수;

import java.util.Arrays;

/**
 * 프로그래머스 level 2 가장 큰 수 - 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

class Solution {


    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));


        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}));
    }
}