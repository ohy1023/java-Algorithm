package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11053 가장 긴 증가하는 수열 ( 실버 2 ) - DP
 * https://www.acmicpc.net/problem/11053
 */
public class BOJ11053 {

    // 주어진 수열에서 가장 긴 증가하는 부분 수열의 길이를 구하는 메서드
    public int solution(int n, int[] seq) {
        if (n == 1) {
            return 1;
        }

        // dp 배열 초기화
        int[] dp = new int[n];
        dp[0] = 1; // 첫 번째 원소는 길이가 1

        int answer = -1; // 가장 긴 부분 수열의 길이를 저장하는 변수

        // 각 위치마다 가장 긴 증가하는 부분 수열의 길이 계산
        for (int i = 1; i < n; i++) {
            int max = 0; // 현재 위치에서의 가장 긴 부분 수열의 길이를 저장하는 변수
            // 현재 위치의 원소보다 작은 이전 원소들을 확인하여 가장 긴 부분 수열의 길이 갱신
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1; // 현재 위치에서의 부분 수열의 길이는 max에 1을 더한 값
            answer = Math.max(answer, dp[i]); // answer 갱신
        }

        return answer; // 최종 가장 긴 부분 수열의 길이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        BOJ11053 s = new BOJ11053();
        System.out.println(s.solution(N, numbers)); // 결과 출력
    }
}
