package programmers.level2.점프와_순간이동;

/**
 * 프로그래머스 점프와 순간이동 (level.2) - 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class Solution {
    /**
     * 숫자 n을 2로 나누거나 1을 빼서 0으로 만들 때 필요한 최소 이동 횟수를 구하는 함수
     *
     * @param n 이동해야 하는 거리
     * @return 필요한 최소 이동 횟수
     */
    public int solution(int n) {
        // 정답을 저장할 변수 초기화
        int ans = 0;

        // n이 0이 될 때까지 반복
        while (n != 0) {
            // 현재 위치가 홀수라면 1을 빼고 이동
            if (n % 2 == 1) {
                ans++;
                n--;
            }

            // 현재 위치를 2로 나눠 이동
            n /= 2;
        }

        // 최소 이동 횟수 반환
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 테스트 케이스 출력
        System.out.println(s.solution(5000));
    }
}
