package baekjoon.str;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17413 단어 뒤집기 2 (실버 3) - 문자열
 * <a href="https://www.acmicpc.net/problem/17413">...</a>
 */
public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        String s = br.readLine();

        boolean insideTag = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                while (word.length() > 0) {
                    sb.append(word.reverse());
                    word.setLength(0);
                }
                insideTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                insideTag = false;
                sb.append(ch);
            } else if (insideTag) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    sb.append(word.reverse());
                    sb.append(' ');
                    word.setLength(0);
                } else {
                    word.append(ch);
                }
            }
        }

        // 남은 단어 뒤집기
        if (word.length() > 0) {
            sb.append(word.reverse());
        }

        System.out.println(sb);
    }
}
