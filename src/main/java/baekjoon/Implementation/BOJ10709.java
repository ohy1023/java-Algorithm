package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10709 기상캐스터 (실버 5) - 구현
 * <a href="https://www.acmicpc.net/problem/10709">...</a>
 */
public class BOJ10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

        for (int i = 0; i < H; i++) {
            String[] line = br.readLine().split("");
            int time = -1;

            for (int j = 0; j < W; j++) {
                if (line[j].equals("c")) {
                    time = 0;
                } else if (time != -1) {
                    time++;
                }
                System.out.print(time + " ");
            }
            System.out.println();
        }
    }
}
