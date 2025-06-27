package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 9375 패션왕 신해빈 (실버 3) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/9375">...</a>
 */
public class BOJ9375 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int cnt = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 1) + 1);

            }

            int answer = 1;

            for (String key : map.keySet()) {
                answer *= map.get(key);
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}

