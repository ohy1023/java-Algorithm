package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 12738 가장 긴 증가하는 부분 수열 3  ( 골드 2 ) - 이진 탐색
 * https://www.acmicpc.net/problem/12738
 */
public class BOJ12738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        List<Long> result = new ArrayList<>();
        result.add(Long.MIN_VALUE);

        for (long a : arr) {
            if (result.get(result.size() - 1) < a) {
                result.add(a);
            } else {
                int lt = 0;
                int rt = result.size();

                while (lt < rt) {
                    int mid = (lt + rt) / 2;

                    if (result.get(mid) >= a) {
                        rt = mid;
                    }else {
                        lt = mid + 1;
                    }
                }

                result.set(rt, a);
            }
        }
        System.out.println(result.size() - 1);
    }
}
