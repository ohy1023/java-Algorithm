package baekjoon.str;

import java.io.*;
import java.util.*;

/**
 * 백준 20291 파일 정리 (실버 3) - 문자열
 * <a href="https://www.acmicpc.net/problem/20291">...</a>
 */
public class BOJ20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> extMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            String ext = fileName.substring(fileName.lastIndexOf('.') + 1);

            extMap.put(ext, extMap.getOrDefault(ext, 0) + 1);
        }

        List<String> keys = new ArrayList<>(extMap.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(" ").append(extMap.get(key)).append("\n");
        }

        System.out.println(sb);

    }
}
