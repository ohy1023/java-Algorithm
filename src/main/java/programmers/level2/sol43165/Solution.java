package programmers.level2.sol43165;

/**
 * 프로그래머스 Level.2 타겟 넘버 - DFS
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
class Solution {
    int answer; // 타겟 넘버를 만드는 방법의 수를 저장하는 변수

    // 깊이 우선 탐색 (DFS) 메서드
    public void dfs(int[] numbers, int target, int depth, int sum) {
        // 모든 숫자를 다 사용한 경우
        if (depth == numbers.length) {
            // 현재 합이 타겟과 같은 경우 방법의 수 증가
            if (sum == target) answer++;
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        // 현재 숫자를 빼는 경우
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

    // 주어진 숫자 배열과 타겟 넘버로 DFS를 시작하는 메서드
    public int solution(int[] numbers, int target) {
        answer = 0; // 방법의 수 초기화

        // DFS 시작: 첫 번째 숫자부터 시작하며 현재 합은 0
        dfs(numbers, target, 0, 0);

        // 방법의 수 반환
        return answer;
    }

    // 테스트 케이스 실행
    public static void main(String[] args) {
        Solution s = new Solution();
        // 첫 번째 테스트 케이스 실행: [1, 1, 1, 1, 1] 배열과 타겟 3
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3));
        // 두 번째 테스트 케이스 실행: [4, 1, 2, 1] 배열과 타겟 4
        System.out.println(s.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
