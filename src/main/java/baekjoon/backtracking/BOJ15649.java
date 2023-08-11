package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

    public static int n, m;
    public static int[] res;
    public static boolean[] check;

    public static StringBuilder sb = new StringBuilder();

    private static void backTracking(int v) {
        if (v == m) {
            for (int val : res) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    res[v] = i;
                    backTracking(v + 1);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        check = new boolean[n + 1];

        backTracking(0);
        System.out.println(sb);

    }


}
