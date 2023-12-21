package programmers.level2.양궁대회;

/**
 * 프로그래머스 양궁대회 (Level 2) - DFS
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92342?language=java
 */
class Solution {

    // 최종 정답 배열
    static int[] answer = {-1};

    // 라이언의 양궁 점수를 저장하는 배열
    static int[] shoot;

    // 최대 점수 차이
    static int maxDiffScore = -Integer.MAX_VALUE;

    /**
     * 양궁 점수 차이 계산 메서드
     *
     * @param apeachShoot 어피치의 양궁 점수 배열
     * @param ryanShoot   라이언의 양궁 점수 배열
     * @return 라이언의 점수에서 어피치의 점수를 뺀 차이
     */
    public int calculateDiff(int[] apeachShoot, int[] ryanShoot) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryanShoot[i] == 0 && apeachShoot[i] == 0) {
                continue;
            }
            if (ryanShoot[i] > apeachShoot[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }

        return ryanScore - apeachScore;
    }

    /**
     * DFS를 통해 양궁의 경우의 수를 탐색하는 메서드
     *
     * @param v    현재 양궁 위치 (0부터 10까지)
     * @param n    남은 화살의 개수
     * @param info 어피치의 양궁 결과 배열
     */
    public void DFS(int v, int n, int[] info) {
        if (v == 11) {
            // 마지막 양궁 위치에 화살이 남아 있는 경우, 양궁 결과 배열의 마지막 인덱스에 남은 화살 개수를 저장
            if (n != 0) {
                shoot[10] = n;
            }
            // 양궁 점수 차이 계산
            int diff = calculateDiff(info, shoot);

            // 양궁 점수 차이가 0 이하인 경우 해당 경우의 수는 무시
            if (diff <= 0) {
                return;
            }

            // 양궁 점수 차이가 최대 차이보다 큰 경우 최대 차이 및 정답 배열 업데이트
            if (diff > maxDiffScore) {
                maxDiffScore = diff;
                answer = shoot.clone();
            }

            // 양궁 점수 차이가 최대 차이가 같은 경우 가장 낮은 점수를 더 많이 맞힌 경우를 정답 배열로 업데이트
            else if (diff == maxDiffScore) {
                for (int i = 10; i >= 0; i--) {
                    if (shoot[i] > answer[i]) {
                        answer = shoot.clone();
                        return;
                    } else if (shoot[i] < answer[i]) return;
                }
            }


            return;
        }

        // 현재 양궁 위치에 화살을 쏠 수 있는 경우
        if (info[v] < n) {
            // 양궁 배열 업데이트 및 다음 양궁 위치로 DFS 호출
            shoot[v] = info[v] + 1;
            DFS(v + 1, n - (info[v] + 1), info);

            // 양궁 배열 원래대로 복구
            shoot[v] = 0;
        }

        // 현재 양궁 위치에 화살을 쏘지 않은 경우
        shoot[v] = 0;

        // 다음 양궁 위치로 DFS 호출
        DFS(v + 1, n, info);
    }

    /**
     * 주어진 조건에 따라 라이언이 우승할 수 있는 양궁 점수 배열을 반환하는 메서드
     *
     * @param n    총 화살의 개수
     * @param info 어피치 양궁 결과 배열
     * @return 라이언이 우승하기 위한 양궁 점수 배열
     */
    public int[] solution(int n, int[] info) {
        // 양궁 점수 배열 초기화
        shoot = new int[11];

        // DFS 탐색 시작
        DFS(0, n, info);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
