package programmers.level3.네트워크;

/**
 * 프로그래머스 level 3 네트워크 - DFS
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
class Solution {
    static boolean[] check; // 방문 여부를 체크하는 배열

    static int res = 0; // 네트워크 개수를 저장하는 변수

    // 깊이 우선 탐색을 통해 네트워크를 찾는 메서드
    public void DFS(int depth, int n, int[][] computers) {
        check[depth] = true; // 현재 노드를 방문했음을 표시

        // 현재 노드와 연결된 다른 노드들을 탐색
        for (int i = 0; i < n; i++) {
            // 현재 노드와 다르고, 연결되어 있으며, 방문하지 않은 경우 재귀 호출
            if (i != depth && computers[depth][i] == 1 && !check[i]) {
                DFS(i, n, computers);
            }
        }
    }

    // 네트워크의 개수를 반환하는 메서드
    public int solution(int n, int[][] computers) {
        check = new boolean[n]; // 방문 여부를 체크하는 배열 초기화

        // 모든 노드에 대해 DFS 수행
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 노드일 경우 DFS 호출하고 네트워크 개수 증가
            if (!check[i]) {
                DFS(i, n, computers);
                res++;
            }
        }

        return res; // 최종적인 네트워크 개수 반환
    }

    // 테스트를 위한 메인 메서드
    public static void main(String[] args) {
        Solution s = new Solution();
        // 예시 입력에 대한 결과 출력
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
