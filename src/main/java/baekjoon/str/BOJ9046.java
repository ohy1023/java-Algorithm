package baekjoon.str;

import java.io.*;


/**
 * 백준 9046 복호화 (브론즈 2) - 문자열
 * <a href="https://www.acmicpc.net/problem/9046">...</a>
 */
public class BOJ9046 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] count = new int[26];
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!Character.isAlphabetic(c)) continue;

                count[c - 'a']++;
            }

            int max = 0;
            char result = '?';
            boolean isDuplicate = false;

            for (int j = 0; j < 26; j++) {
                if (count[j] > max) {
                    max = count[j];
                    result = (char) (j + 'a');
                    isDuplicate = false;
                } else if (count[j] == max) {
                    isDuplicate = true;
                }
            }

            sb.append(isDuplicate ? "?\n" : result + "\n");

        }

        System.out.println(sb);


    }

}
