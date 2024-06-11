package programmers.level2.sol154539;

import java.util.*;

/**
 * 프로그래머스 뒤에 있는 큰 수 찾기 (Level.2) - 스택
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
class Solution {
    /**
     * 각 숫자 뒤에 있는 큰 수를 찾는 메서드
     * @param numbers 주어진 숫자 배열
     * @return 각 숫자 뒤에 있는 큰 수 배열
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> s = new Stack<>();

        // 스택에 첫 번째 숫자의 인덱스를 넣음
        s.push(0);

        for (int i = 1; i < numbers.length; i ++) {
            // 스택이 비어있지 않고, 현재 숫자가 스택의 가장 위에 있는 숫자보다 클 경우
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                // 스택의 가장 위에 있는 숫자의 인덱스에 현재 숫자를 대입하고 해당 숫자를 스택에서 제거
                answer[s.pop()] = numbers[i];
            }

            // 현재 숫자의 인덱스를 스택에 추가
            s.push(i);
        }

        // 스택에 남아있는 인덱스들은 뒤에 큰 수가 없는 경우이므로 -1로 대체
        while (!s.isEmpty()) {
            answer[s.pop()] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 주어진 예시 입력에 대한 결과 출력
        int[] result = s.solution(new int[]{9, 1, 5, 3, 6, 2});
        for (int r : result) {
            System.out.println(r + " ");
        }
    }
}
