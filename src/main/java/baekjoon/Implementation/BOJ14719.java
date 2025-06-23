package baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * 백준 14719 빗물 (골드 5) - 구현
 * <a href="https://www.acmicpc.net/problem/14719">...</a>
 */
public class BOJ14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] blocks = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                blocks[H - j - 1][i] = 1;
            }
        }
        int answer = 0;

        for (int i = 0; i < H; i++) {
            Integer preBlockIdx = null;
            for (int j = 0; j < W; j++) {
                if (blocks[i][j] == 1) {
                    if (preBlockIdx != null) {
                        answer += j - preBlockIdx - 1;
                    }
                    preBlockIdx = j;
                }
            }
        }

        System.out.println(answer);
    }
}
