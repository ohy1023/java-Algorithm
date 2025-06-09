package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1138 - 한 줄로 서기 (실버 2)
 * https://www.acmicpc.net/problem/1138
 */
public class BOJ1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int leftCount = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 0; j < N; j++) {
                if (answer[j] == 0) {
                    if (count == leftCount) {
                        answer[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }


        for (int a : answer) {
            System.out.print(a + " ");
        }

    }
}
