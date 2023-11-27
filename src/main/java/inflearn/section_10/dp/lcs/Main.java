package inflearn.section_10.dp.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 인프런 LCS - DP
 */
public class Main {
    public int solution(int n, int[] seq) {
        int[] dp = new int[n];
        dp[0] = 1;
        int answer = -1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }


        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(N, numbers));
    }
}
