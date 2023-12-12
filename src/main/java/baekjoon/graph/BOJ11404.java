package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11404 플로이드 (골드 4) - 플로이드 와샬 알고리즘
 * https://www.acmicpc.net/problem/11404
 */
public class BOJ11404 {
    static int n;
    static int[][] graph;
    static final int INF = 987654321;


    public void floyd() {
        // k를 경유하여 i에서 j로 가는 최단 경로 계산
        for (int k = 1; k <= n; k++) {
            // 출발지 i
            for (int i = 1; i <= n; i++) {
                // 도착지 j
                for (int j = 1; j <= n; j++) {
                    // i에서 j로 가는 현재 최단 경로와 i에서 k를 거쳐 j로 가는 경로를 비교하여 갱신
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 정점의 개수
        int m = Integer.parseInt(br.readLine()); // 간선의 개수

        graph = new int[n + 1][n + 1]; // 그래프 초기화

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0; // 자기 자신으로의 경로는 0
                    continue;
                }

                graph[i][j] = INF; // 나머지는 무한대로 초기화
            }
        }

        StringTokenizer st;

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 더 작은 비용으로 갱신
            graph[a][b] = Math.min(c, graph[a][b]);
        }

        BOJ11404 main = new BOJ11404();
        main.floyd(); // 플로이드-와샬 알고리즘으로 최단 경로 찾기

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    graph[i][j] = 0; // 무한대인 경우 0으로 변환
                }
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
