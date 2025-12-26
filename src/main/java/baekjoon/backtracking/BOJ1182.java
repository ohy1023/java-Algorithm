package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 부분수열의 합 (실버 2) - 백 트래킹
 * https://www.acmicpc.net/problem/1182
 */
public class BOJ1182 {

    static int N, S, answer = 0;
    static int[] arr;

    public static void solve(int idx, int sum) {
        if (idx == N) {
            if (sum == S) answer++;
            return;
        }

        solve(idx + 1, sum + arr[idx]);
        solve(idx + 1, sum);

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0,0);

        System.out.println(S == 0 ? answer - 1 : answer);
    }

}
