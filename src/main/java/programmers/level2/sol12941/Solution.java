package programmers.level2.sol12941;

import java.util.*;

/**
 * 프로그래머스 최솟값 만들기
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=java">...</a>
 */
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A); // A는 오름차순 정렬

        // B를 최대 힙으로 처리 (내림차순)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : B) {
            maxHeap.add(num);
        }

        for (int num : A) {
            answer += num * maxHeap.poll(); // A는 오름차순, B는 최대값부터 가져옴
        }

        return answer;
    }
}