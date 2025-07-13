package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 2910 문자열 집합 (실버 3) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/2910">...</a>
 */
public class BOJ2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st.nextToken();

        Map<Integer, Integer> countMap = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(countMap.keySet());

        keys.sort((o1, o2) -> Integer.compare(countMap.get(o2), countMap.get(o1)));

        for (Integer key : keys) {
            for (int i = 0; i < countMap.get(key); i++) {
                sb.append(key).append(' ');
            }

        }

        System.out.println(sb);
    }
}
