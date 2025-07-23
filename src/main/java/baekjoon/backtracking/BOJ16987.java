package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16987 계란으로 계란치기 - 백 트래킹
 * <a href="https://www.acmicpc.net/problem/16987">...</a>
 */
public class BOJ16987 {

    static int N, answer;
    static int[] durability;
    static int[] weight;

    private static void DFS(int idx, int cnt) {
        if (idx == N + 1) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (durability[idx] <= 0 || cnt == N - 1) {
            DFS(idx + 1, cnt);
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (i == idx || durability[i] <= 0) continue;

            durability[i] -= weight[idx];
            durability[idx] -= weight[i];

            int broken = 0;
            if (durability[i] <= 0) broken++;
            if (durability[idx] <= 0) broken++;

            DFS(idx + 1, cnt + broken);

            durability[i] += weight[idx];
            durability[idx] += weight[i];
        }

    }

    public static void main(String[] args) throws IOException {
        answer = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        durability = new int[N + 1];
        weight = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, 0);

        System.out.println(answer);
    }

}
