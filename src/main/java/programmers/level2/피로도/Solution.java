package programmers.level2.피로도;

/**
 * 프로그래머스 level 2 피로도 - 완전탐색
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
class Solution {

    // 결과값을 저장하는 변수
    public static int res = -1;

    // 방문 여부를 저장하는 배열
    static boolean[] visited;

    /**
     * 깊이 우선 탐색을 통해 가능한 모든 경우를 탐색하고 최대 피로도를 계산하는 메서드
     *
     * @param v         현재까지의 방문한 던전 수
     * @param k         현재 남은 체력
     * @param dungeons  던전 정보를 담은 2차원 배열
     */
    public void dfs(int v, int k, int[][] dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            // 해당 던전을 아직 방문하지 않았고, 현재 체력으로 갈 수 있는 던전인 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;  // 해당 던전을 방문 표시
                dfs(v + 1, k - dungeons[i][1], dungeons);  // 다음 던전으로 이동
                visited[i] = false; // 백트래킹: 해당 던전을 다시 방문하지 않도록 방문 표시 해제
            }
        }
        // 현재까지 방문한 던전 수를 최대값과 비교하여 갱신
        res = Math.max(res, v);

    }

    /**
     * 주어진 체력으로 모든 던전을 탐험할 때 최대로 방문할 수 있는 던전 수를 반환하는 메서드
     *
     * @param k         초기 체력
     * @param dungeons  던전 정보를 담은 2차원 배열
     * @return          최대 방문 가능한 던전 수
     */
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];  // 방문 여부를 저장하는 배열 초기화

        dfs(0, k, dungeons);  // DFS 호출

        return res;  // 최종 결과 반환
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예시 입력에 대한 테스트
        System.out.println(s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
