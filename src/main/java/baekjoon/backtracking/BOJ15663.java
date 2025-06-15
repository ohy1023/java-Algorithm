package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 백준 15663 N 과 M (9) - 백 트래킹
 * <a href="https://www.acmicpc.net/problem/15663">...</a>
 */
public class BOJ15663 {

    static int N, M;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set;

    static void backTracking(int depth) {
        if (depth == M) {
            StringBuilder sb1 = new StringBuilder();
            for (int t : tmp) {
                sb1.append(t).append(" ");
            }

            if (!set.contains(sb1.toString())) {
                sb.append(sb1).append("\n");
                set.add(sb1.toString());
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmp[depth] = arr[i];
            backTracking(depth + 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[M];
        visited = new boolean[N];
        set = new HashSet<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sb = new StringBuilder();

        backTracking(0);

        System.out.println(sb);
    }
}
