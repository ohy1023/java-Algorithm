package baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 백준 1764 듣보잡 실버 4
 */
public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> res = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            hashMap.put(key, 1);
        }

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            if (hashMap.get(key) == 2) {
                res.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(res);

        sb.append(res.size()).append('\n');

        for (String name : res) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);



    }
}
