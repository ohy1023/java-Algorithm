package baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1515 수 이어 쓰기 (실버 3) - 문자열
 * <a href="https://www.acmicpc.net/problem/1515">...</a>
 */
public class BOJ1515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int pt = 0;
        int base = 0;

        while (pt < arr.length) {
            String num = String.valueOf(++base);

            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == arr[pt]) pt++;
                if (pt >= arr.length) break;
            }
        }

        System.out.println(base);
    }
}
