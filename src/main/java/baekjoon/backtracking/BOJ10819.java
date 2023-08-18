package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10819 차이를 최대로 실버 2 - 백트래킹을 사용한 풀이
 */
public class BOJ10819 {

    public static int n, ans;
    public static int[] arr, res;
    public static boolean[] check;

    public static int backTracking(int v) {
        if (v == n) {
            int tmp = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                tmp += Math.abs(res[i] - res[i + 1]);
            }

            if (ans < tmp) {
                ans = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                res[v] = arr[i];
                backTracking(v + 1);
                check[i] = false;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        arr = new int[n];
        res = new int[n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backTracking(0));

    }
}
