package baekjoon.binary_search;


import java.io.*;
import java.util.*;

/**
 * 백준 2110 공유기 설치  ( 골드 4 ) - 이진 탐색
 * <a href="https://www.acmicpc.net/problem/2110">...</a>
 */
public class BOJ2110 {

    static int[] cord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cord = new int[N];

        for (int i = 0; i < N; i++) {
            cord[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cord);

        int lt = 1;
        int rt = cord[N - 1] - cord[0];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (canInstall(mid) < M) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }

        System.out.println(lt - 1);
    }

    private static int canInstall(int mid) {
        int cnt = 1;
        int lastInstallCord = cord[0];

        for (int i = 1; i < cord.length; i++) {
            if (cord[i] >= lastInstallCord + mid) {
                cnt++;
                lastInstallCord = cord[i];
            }
        }
        return cnt;
    }

}
