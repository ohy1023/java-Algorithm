package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2565 전깃줄 (골드 5) - DP
 * https://www.acmicpc.net/problem/2565
 */
public class BOJ2565 {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전깃줄의 개수를 나타내는 변수 n 초기화
        int n = Integer.parseInt(br.readLine());

        // 전깃줄의 정보를 저장할 2차원 배열 info 초기화
        int[][] info = new int[n][2];

        // DP 테이블을 저장할 배열 dp 초기화
        int[] dp = new int[n];

        // StringTokenizer를 사용하여 전깃줄 정보 입력
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // 전깃줄의 두 번호를 각각 p1, p2에 저장
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            // 전깃줄 정보를 2차원 배열에 저장
            info[i][0] = p1;
            info[i][1] = p2;
        }

        // 전깃줄의 첫 번호를 기준으로 정렬
        Arrays.sort(info, (o1, o2) -> o1[0] - o2[0]);

        // 최장 증가 부분 수열(LIS) 알고리즘을 이용하여 dp 배열 채우기
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            // 현재 전깃줄과 이전 전깃줄을 비교하여 증가 부분 수열 확인
            for (int j = 0; j < i; j++) {
                if (info[i][1] > info[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 최대값 갱신
            max = Math.max(max, dp[i]);
        }

        // 결과 출력
        System.out.println(n - max);
    }
}
