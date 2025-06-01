package baekjoon.sliding_window;

import java.io.*;

/**
 * 백준 1522 문자열 교환 (실버 1) - 슬라이딩 윈도우
 * <a href="https://www.acmicpc.net/problem/1522">...</a>
 */
public class BOJ1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aCnt++;
        }

        String circularString = s + s;
        int[] prefixSum = new int[circularString.length() + 1];
        for (int i = 1; i <= circularString.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (circularString.charAt(i - 1) == 'b' ? 1 : 0);
        }

        int answer = s.length();
        for (int start = 0; start <= circularString.length() - aCnt; start++) {
            int end = start + aCnt;
            int bCnt = prefixSum[end] - prefixSum[start];

            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);
    }
}