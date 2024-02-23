package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 3273 두 수의 합 (실버 3) - 투 포인터
 * https://www.acmicpc.net/problem/3273
 */
public class BOJ3273 {

    /**
     * 주어진 배열에서 두 수의 합이 target이 되는 경우의 수를 반환하는 메소드
     * @param n 배열의 길이
     * @param target 목표 합
     * @param arr 주어진 배열
     * @return 두 수의 합이 target이 되는 경우의 수
     */
    static int solution(int n, int target, int[] arr) {
        Arrays.sort(arr); // 배열을 오름차순 정렬

        int answer = 0; // 경우의 수를 저장할 변수
        int lt = 0; // 배열의 왼쪽 포인터
        int rt = arr.length - 1; // 배열의 오른쪽 포인터

        // lt와 rt가 만날 때까지 반복
        while (lt < rt) {
            int sum = arr[lt] + arr[rt]; // 현재 합 계산

            if (sum <= target) { // 현재 합이 target 이하인 경우
                lt++; // 왼쪽 포인터를 오른쪽으로 이동하여 합을 증가시킴
            } else { // 현재 합이 target 초과인 경우
                rt--; // 오른쪽 포인터를 왼쪽으로 이동하여 합을 감소시킴
            }

            if (sum == target) { // 두 수의 합이 target인 경우
                answer++; // 경우의 수 증가
            }
        }
        return answer; // 결과 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열의 길이 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 요소 입력
        }

        int x = Integer.parseInt(br.readLine()); // 목표 합 입력

        // 결과 출력
        System.out.println(solution(n, x, arr));
    }
}
