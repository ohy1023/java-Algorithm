package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 문자열 판별 (골드 5) - DP
 * https://www.acmicpc.net/problem/16500
 */
public class BOJ16500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 문자열
        String s = br.readLine();

        // 입력된 부분 문자열 집합
        Set<String> set = new HashSet<>();

        // 동적 계획법 배열
        int[] dp = new int[101];

        // 부분 문자열 개수
        int n = Integer.parseInt(br.readLine());

        // 부분 문자열 집합에 추가
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // 문자열을 뒤에서부터 검사
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // j부터 끝까지의 문자열이 이미 만들어질 수 있는 문자열인 경우
                if (dp[j] == 1) {
                    // 부분 문자열 집합에 포함되어 있는지 확인
                    if (set.contains(s.substring(i, j))) {
                        dp[i] = 1; // 만들 수 있는 문자열로 표시
                    }
                }
            }

            // i부터 끝까지의 문자열이 부분 문자열 집합에 포함되어 있는지 확인
            if (set.contains(s.substring(i))) {
                dp[i] = 1; // 만들 수 있는 문자열로 표시
            }
        }

        // 첫 번째 문자부터 시작하는 문자열이 만들어질 수 있는지 여부 출력
        System.out.println(dp[0]);
    }
}
