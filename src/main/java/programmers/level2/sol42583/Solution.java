package programmers.level2.sol42583;

import java.util.*;

/**
 * 프로그래머스 Level.2 다리를 지나는 트럭 - 큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 **/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 다리 길이가 1인 경우, 모든 트럭이 1초마다 다리를 건너므로 총 시간은 트럭 수 + 1
        if (bridge_length == 1) return truck_weights.length + 1;
        // 트럭이 1대인 경우, 다리를 건너는 데 걸리는 시간은 다리 길이 + 1
        if (truck_weights.length == 1) return bridge_length + 1;

        // 다리를 건너는 트럭을 관리하기 위한 큐
        Queue<Integer> q = new LinkedList<>();

        // 초기 다리 상태를 0으로 채워줌
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }

        int idx = 0; // 현재 대기 중인 트럭의 인덱스
        int curWeight = 0; // 현재 다리 위의 트럭 무게 합계

        // 대기 중인 트럭이 모두 다리를 건널 때까지 반복
        while (idx < truck_weights.length) {
            // 다리의 맨 앞부분에서 트럭이 빠져나가므로 그 무게를 빼줌
            curWeight -= q.poll();
            answer++; // 시간 경과

            // 현재 다리 위의 트럭 무게와 다음 트럭의 무게를 합쳐도 제한 무게를 넘지 않으면
            if (curWeight + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]); // 트럭이 다리로 진입
                curWeight += truck_weights[idx++]; // 다리 위의 총 무게에 추가하고 다음 트럭으로 이동
            } else {
                // 무게를 초과하면 0을 추가하여 다리 상태를 유지
                q.offer(0);
            }
        }

        // 마지막 트럭이 다리를 모두 건너기 위해 다리 길이만큼의 시간이 추가로 필요함
        return answer + bridge_length;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;




        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 10, new int[]{7, 4, 5, 6})); // 예시 테스트
        System.out.println(s.solution(100, 100, new int[]{10})); // 예시 테스트
        System.out.println(s.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); // 예시 테스트
    }
}
