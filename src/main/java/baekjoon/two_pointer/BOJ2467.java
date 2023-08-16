package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * 백준 2467 용액 골드 5
 */
public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] liquids = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = n - 1;
        int res1 = 0;
        int res2 = 0;

        long minValue = Long.MAX_VALUE;

        while (lt < rt) {
            long tmp = liquids[lt] + liquids[rt];

            if (abs(tmp) < abs(minValue)) {

                res1 = lt;
                res2 = rt;
                minValue = tmp;

                if (minValue == 0) {
                    break;
                }
            }

            if (tmp < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.print(liquids[res1] + " " + liquids[res2]);


    }
}
