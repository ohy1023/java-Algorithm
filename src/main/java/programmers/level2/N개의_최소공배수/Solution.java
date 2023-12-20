package programmers.level2.N개의_최소공배수;

/**
 * 프로그래머스 level 2 N개의 최소공배수 - 유클리드 호제법
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */
class Solution {

    // 최대공약수 계산 메서드
    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        if (a % b == 0) {
            return b;
        }

        return calculateGCD(b, a % b);
    }

    // 최소공배수 계산 메서드
    private int calculateLCM(int a, int b) {
        return a * b / calculateGCD(a, b);
    }

    // 주어진 배열의 최소공배수를 계산하는 메서드
    public int solution(int[] arr) {
        if (arr.length == 0) {
            return 0; // 빈 배열에 대한 처리 (예외 상황)
        }

        int answer = arr[0];

        // 배열의 모든 원소에 대해 최소공배수를 계산
        for (int i = 1; i < arr.length; i++) {
            answer = calculateLCM(answer, arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예시 입력에 대한 최소공배수 출력
        System.out.println(s.solution(new int[]{2, 6, 8, 14}));
    }
}
