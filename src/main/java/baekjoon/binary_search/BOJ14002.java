package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 14002 가장 긴 증가하는 수열 3 골드 2 - 이분탐색을 사용한 풀이
 */
public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] sequence = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Long.parseLong(st.nextToken());
        }

        List<Long> res = new ArrayList<>();
        res.add(Long.MIN_VALUE);

        for (long s : sequence) {
            if (res.get(res.size() - 1) < s) {
                res.add(s);
            } else {
                int lt = 1;
                int rt = res.size();

                while (lt < rt) {
                    int mid = (lt + rt) / 2;

                    if (res.get(mid) < s) {
                        lt = mid + 1;
                    } else {
                        rt = mid;
                    }
                }
                res.set(rt, s);
            }
        }
        System.out.println(res.size() - 1);
    }
}
