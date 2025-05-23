package baekjoon.str;

import java.io.*;

/**
 * 백준 1254 팰린드롬 만들기 (실버 2) - 문자열
 * <a href="https://www.acmicpc.net/problem/1254">...</a>
 */
public class BOJ1254 {
    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
