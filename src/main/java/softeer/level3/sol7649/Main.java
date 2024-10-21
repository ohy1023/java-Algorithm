package softeer.level3.sol7649;

import java.io.*;
import java.util.*;

/**
 * 소프티어 효도 여행 - DFS, DP
 * https://softeer.ai/practice/7649
 */
public class Main {

    static class Edge {
        int node;  // 연결된 노드 번호
        char course;  // 노드 연결에 해당하는 문자

        public Edge(int node, char course) {
            this.node = node;
            this.course = course;
        }
    }

    static String S;  // 조건을 만족해야 하는 문자열
    static List<Edge>[] tree;  // 각 노드의 연결 정보를 저장하는 리스트 배열
    static int[][] dp;  // 최대 일치 길이를 저장하는 다이나믹 프로그래밍 테이블
    static boolean[] visited;  // 노드 방문 여부를 저장하는 배열
    static int answer;  // 최종 결과 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 노드의 수
        int M = Integer.parseInt(st.nextToken());  // 문자열의 길이

        S = br.readLine();  // 비교할 문자열

        tree = new ArrayList[N + 1];  // 각 노드의 연결 정보를 저장
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        dp = new int[5002][5002];  // dp 배열 초기화
        visited = new boolean[N + 1];  // 방문 배열 초기화
        answer = 0;

        // 간선 정보 입력 받기
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
        }

        dfs(0, 1);  // DFS를 이용한 탐색 시작

        System.out.println(answer);  // 결과 출력
    }

    // DFS를 통해 트리를 탐색하면서 조건에 맞는 최대 길이 계산
    public static void dfs(int depth, int node) {
        visited[node] = true;
        boolean isLeaf = true;  // 현재 노드가 리프 노드인지 판단

        // 연결된 간선 정보를 이용해 재귀적으로 탐색
        for (Edge edge : tree[node]) {
            if (!visited[edge.node]) {
                isLeaf = false;

                for (int i = 0; i < S.length(); i++) {
                    char c2 = S.charAt(i);
                    // 문자열 조건을 비교하여 dp 값을 갱신
                    dp[depth + 1][i + 1] = Math.max(dp[depth][i] + ((edge.course == c2) ? 1 : 0),
                            Math.max(dp[depth][i + 1], dp[depth + 1][i]));
                }

                dfs(depth + 1, edge.node);  // 다음 노드로 재귀 호출
                visited[edge.node] = false;
            }
        }

        // 리프 노드에서 최대 길이를 계산하여 결과 갱신
        if (isLeaf) {
            for (int j = 0; j < S.length(); j++) {
                answer = Math.max(answer, dp[depth][j + 1]);
            }
        }
    }
}
