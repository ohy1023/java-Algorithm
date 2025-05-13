package baekjoon.greedy;

import java.io.*;

/**
 * 백준 1105 팔 (실버 1) - 그리디
 * <a href="https://www.acmicpc.net/problem/1105">...</a>
 */
public class BOJ1105 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String L = s[0];
        String R = s[1];

        int cnt = 0;

        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) break;
                if (L.charAt(i) == '8') cnt++;
            }
        }

        System.out.println(cnt);

    }
}
