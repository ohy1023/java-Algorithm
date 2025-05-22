package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 14467 소가 길을 건너간 이유 1 (브론즈 1) - 구현
 * <a href="https://www.acmicpc.net/problem/14467">...</a>
 */
public class BOJ14467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            Integer prevPos = map.get(no);

            if (prevPos == null) {
                map.put(no, pos);
            } else if (prevPos != pos) {
                answer++;
                map.put(no, pos);
            }

        }

        System.out.println(answer);
    }

}
