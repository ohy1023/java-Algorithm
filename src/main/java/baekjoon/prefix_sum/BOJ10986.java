package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 나머지 합 ( 골드 3 ) - 누적 합
 * https://www.acmicpc.net/problem/10986
 */
public class BOJ10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] cnt = new int[1000];
        long answer = 0;

        st = new StringTokenizer(br.readLine());


        while (N-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            sum %= M;
            answer += cnt[sum];
            cnt[sum]++;
            if (sum == 0) answer++;
        }

        System.out.println(answer);
    }
}
