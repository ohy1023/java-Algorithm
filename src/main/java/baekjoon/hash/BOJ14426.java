package baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> prefixes = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String word = br.readLine().trim();
            for (int j = 1; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                prefixes.put(prefix, true);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String testStr = br.readLine().trim();
            if (prefixes.containsKey(testStr)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
