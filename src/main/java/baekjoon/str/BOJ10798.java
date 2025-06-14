package baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 10798 세로 읽기 (브론즈 1) - 문자열
 * <a href="https://www.acmicpc.net/problem/10798">...</a>
 */
public class BOJ10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] ch = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                ch[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] == '\0') continue;
                sb.append(ch[j][i]);
            }
        }

        System.out.println(sb);
    }

}
