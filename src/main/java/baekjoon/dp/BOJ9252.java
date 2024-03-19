package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 9252 LCS 2 (골드 4) - DP
 * https://www.acmicpc.net/problem/9252
 */
public class BOJ9252 {

    static int[][] dp; // DP 테이블
    static StringBuilder sb = new StringBuilder(); // LCS 문자열을 저장할 StringBuilder

    /**
     * LCS 길이를 계산하여 StringBuilder에 추가하는 메소드
     * @param a 첫 번째 문자열
     * @param b 두 번째 문자열
     */
    public static void lcs(String a, String b) {

        // DP 테이블 초기화
        dp = new int[a.length() + 1][b.length() + 1];

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

        // LCS의 길이를 StringBuilder에 추가
        sb.append(dp[a.length()][b.length()]).append("\n");

    }

    /**
     * LCS 문자열을 스택을 이용하여 역추적하고 StringBuilder에 추가하는 메소드
     * @param a 첫 번째 문자열
     * @param b 두 번째 문자열
     */
    public static void getLcs(String a, String b) {
        int n = a.length();
        int m = b.length();

        Stack<Character> st = new Stack<>(); // LCS 문자열을 저장할 스택

        // 역추적을 통해 LCS 문자열을 스택에 추가
        while (n > 0 && m > 0) {
            if (dp[n][m] == dp[n - 1][m]) {
                n--;
            } else if (dp[n][m] == dp[n][m - 1]) {
                m--;
            } else {
                st.push(a.charAt(n - 1));
                n--;
                m--;
            }
        }

        // 스택에 저장된 LCS 문자열을 StringBuilder에 추가
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String a = br.readLine();
        String b = br.readLine();

        // LCS 길이 계산 및 StringBuilder에 추가
        lcs(a, b);

        // LCS 문자열 역추적 및 StringBuilder에 추가
        getLcs(a, b);

        // 결과 출력
        System.out.println(sb);
    }
}
