package inflearn.string.회문_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        char[] chars = input.toCharArray();
        int lt = 0;
        int rt = input.length() - 1;
        while (lt < rt) {
            if (chars[lt] != chars[rt]) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        if (isPalindrome(br.readLine())) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb);

    }
}
