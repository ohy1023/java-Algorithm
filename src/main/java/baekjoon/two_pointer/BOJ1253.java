package baekjoon.two_pointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2018 좋다 (골드 4)- 투 포인터
 * <a href="https://www.acmicpc.net/problem/2018">...</a>
 */
public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int lt = 0;
            int rt = N - 1;
            while (true) {
                if (lt == i) {
                    lt++;
                }
                if (rt == i) {
                    rt--;
                }

                if (lt >= rt)	break;

                int sum = arr[lt] + arr[rt];
                if (sum > target) {
                    rt--;
                } else if (sum == target) {
                    answer++;
                    break;
                } else {
                    lt++;
                }
            }
        }
        System.out.println(answer);
    }

}
