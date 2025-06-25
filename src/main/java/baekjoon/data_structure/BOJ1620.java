package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 1620 나는야 포켓몬 마스터 이다솜 (실버 4) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/1620">...</a>
 */
public class BOJ1620 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> nameToNumber = new HashMap<>();
        Map<String, String> numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();

            nameToNumber.put(name, String.valueOf(i));
            numberToName.put(String.valueOf(i), name);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();

            String result = nameToNumber.get(key) == null ? numberToName.get(key) : nameToNumber.get(key);

            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }
}
