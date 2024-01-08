package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 퇴사 2 (골드 5) - DP
 * https://www.acmicpc.net/problem/15486
 */
public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 일수를 나타내는 변수 N을 입력 받습니다.
        int N = Integer.parseInt(br.readLine());

        // StringTokenizer를 사용하여 각 일에 소요되는 시간과 보수를 저장할 배열을 선언합니다.
        StringTokenizer st;

        // 각 일에 소요되는 시간과 보수를 저장할 배열입니다.
        int[] time = new int[N + 2];
        int[] pay = new int[N + 2];

        // 입력 받은 일에 대한 정보를 배열에 저장합니다.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // 각 날짜까지의 최대 이익을 저장할 배열입니다.
        int[] dp = new int[N + 2];

        // 최대 이익을 나타내는 변수입니다.
        int max = 0;

        // 각 날짜별로 최대 이익을 계산합니다.
        for (int i = 1; i <= N + 1; i++) {
            // 현재까지의 최대 이익과 비교하여 더 큰 값으로 갱신합니다.
            if (max < dp[i]) {
                max = dp[i];
            }

            // 현재 일을 마치고 다음 일을 할 수 있는 날짜를 계산합니다.
            int day = i + time[i];

            // 다음 일을 할 수 있는 날짜가 전체 일수를 초과하지 않는 경우,
            // 해당 날짜까지의 최대 이익을 갱신합니다.
            if (day <= N + 1) {
                dp[day] = Math.max(dp[day], max + pay[i]);
            }
        }

        // 최종적으로 구한 최대 이익을 출력합니다.
        System.out.println(max);
    }
}
