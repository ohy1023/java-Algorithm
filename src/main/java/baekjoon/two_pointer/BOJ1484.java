package baekjoon.two_pointer;

import java.io.*;

/**
 * 백준 1484 다이어트 (골드 5) - 투 포인터
 * https://www.acmicpc.net/problem/1484
 */
public class BOJ1484 {

    static StringBuilder sb = new StringBuilder();

    // 가능한 몸무게 조합을 찾는 메서드
    public void solution(int G) {
        int x = 1;
        int y = 1;

        // 투 포인터 알고리즘을 이용하여 가능한 몸무게 조합을 찾음
        while (true) {
            int diff = x * x - y * y;
            // 더 이상 조합이 없는 경우 종료
            if (x - y == 1 && diff > G) break;

            // 몸무게 차이가 G보다 작으면 x를 증가시킴
            if (diff < G) x++;
                // 몸무게 차이가 G보다 크거나 같으면 y를 증가시킴
            else y++;

            // 몸무게 차이가 G인 경우 결과에 추가
            if (diff == G) sb.append(x).append("\n");
        }

        // 결과가 없는 경우 -1 출력
        if (sb.toString().equals("")) {
            sb.append(-1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        BOJ1484 b = new BOJ1484();
        b.solution(G);

        System.out.println(sb);
    }
}
