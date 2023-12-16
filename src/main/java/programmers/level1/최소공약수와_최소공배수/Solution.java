package programmers.level1.최소공약수와_최소공배수;

/**
 * 프로그래머스 level 1 최대공약수와 최소공배수 - 유클리드 호제법
 * https://school.programmers.co.kr/learn/courses/30/lessons/12940
 */
class Solution {
    /**
     * 최대공약수를 계산하는 메서드
     *
     * @param a 자연수
     * @param b 자연수
     * @return 최대공약수
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    /**
     * 주어진 두 자연수의 최대공약수와 최소공배수를 계산하는 메서드
     *
     * @param n 자연수
     * @param m 자연수
     * @return 최대공약수와 최소공배수를 담은 배열
     */
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        // 두 수 중 큰 수와 작은 수 결정
        int bigValue = Math.max(n, m);
        int smallValue = Math.min(n, m);

        // 최대공약수 계산
        answer[0] = gcd(bigValue, smallValue);

        // 최소공배수 계산
        answer[1] = bigValue * smallValue / answer[0];

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] results = s.solution(3, 0);

        // 결과 출력
        System.out.println("최대공약수: " + results[0]);
        System.out.println("최소공배수: " + results[1]);
    }
}
