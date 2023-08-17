package baekjoon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * 백준 9342 염색체 실버 3 - 정규 표현식을 사용한 풀이
 */
public class BOJ9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String pattern = "^[A-F]?A+F+C+[A-F]?$";

        for (int i = 0; i < n; i++) {

            String input = br.readLine();
            boolean isMatches = Pattern.matches(pattern, input);

            if (isMatches) {
                sb.append("Infected!");
            } else {
                sb.append("Good");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
