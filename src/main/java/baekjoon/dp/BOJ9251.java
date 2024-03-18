package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9251 LCS (골드 5) - DP
 * https://www.acmicpc.net/problem/9251
 */
public class BOJ9251 {

    /**
     * 최장 공통 부분 수열의 길이를 계산하는 메소드
     * @param a 문자열 a
     * @param b 문자열 b
     * @return 최장 공통 부분 수열의 길이
     */
    public static int solution(String a, String b) {

        // DP 테이블 초기화
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        // 두 문자열을 비교하며 DP 테이블 갱신
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // 문자가 같으면 이전 대각선 값에 1을 더하여 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 문자가 다르면 왼쪽 값 또는 위쪽 값 중 최댓값으로 갱신
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최장 공통 부분 수열의 길이 반환
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String a = br.readLine();
        String b = br.readLine();

        // 최장 공통 부분 수열의 길이 출력
        System.out.println(solution(a, b));
    }
}
