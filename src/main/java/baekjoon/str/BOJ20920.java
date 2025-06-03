package baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 20920 영단어 암기는 괴로워 (실버 3) - 문자열
 * <a href="https://www.acmicpc.net/problem/20920">...</a>
 */
public class BOJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.length() < M) continue;
            result.put(line, result.getOrDefault(line, 0) + 1);
        }

        List<String> words = new ArrayList<>(result.keySet());

        words.sort((o1, o2) -> {
            int c1 = result.get(o1);
            int c2 = result.get(o2);

            if (c1 != c2) return Integer.compare(c2, c1);
            if (o1.length() != o2.length()) return Integer.compare(o2.length(), o1.length());

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
