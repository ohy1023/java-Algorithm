package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805 나무 자르기  ( 실버 2 ) - 이진 탐색
 * <a href="https://www.acmicpc.net/problem/2805">...</a>
 */
public class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int lt = 0;
        int rt = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(tree[i], rt);
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            for (int t : tree) {
                if (t > mid) sum += t - mid;
            }

            if (sum >= M) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(rt);

    }
}
