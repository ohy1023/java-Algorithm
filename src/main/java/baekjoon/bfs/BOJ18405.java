package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 18405 경쟁적 전염 (골드 5) - BFS
 * https://www.acmicpc.net/problem/18405
 */
public class BOJ18405 {

    static int N, K, S, X, Y;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Virus> q = new LinkedList<>();

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int value;
        int order;

        public Virus(int x, int y, int value, int order) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.order = order;
        }

        @Override
        public int compareTo(Virus o) {
            return (this.order == o.order) ? Integer.compare(this.value, o.value) : Integer.compare(this.order, o.order);
        }
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Virus curVirus = q.poll();
            int x = curVirus.x;
            int y = curVirus.y;
            int v = curVirus.value;
            int o = curVirus.order;

            if (o == S) return board[X - 1][Y - 1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || 0 > ny || nx >= N || ny >= N) continue;
                if (board[nx][ny] != 0) continue;
                if (nx == X - 1 && ny == Y - 1) return board[x][y];

                board[nx][ny] = v;
                q.offer(new Virus(nx, ny, v, o + 1));

            }
        }

        return board[X - 1][Y - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        ArrayList<Virus> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0) {
                    list.add(new Virus(i, j, board[i][j], 0));
                }
            }
        }

        Collections.sort(list, new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return o1.value - o2.value;
            }
        });

        for (Virus virus : list) {
            q.offer(virus);
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

}
