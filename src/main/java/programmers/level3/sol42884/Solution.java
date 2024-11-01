package programmers.level3.sol42884;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스 Level.3 단속 카메라 - 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class Solution {

    // 시작 지점을 기준으로 카메라 설치
    public int startSolution(int[][] routes) {
        // 시작 지점을 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

        int answer = 0; // 설치된 카메라의 수
        int e = Integer.MIN_VALUE; // 현재 설치된 카메라의 위치

        for (int[] route : routes) {
            // 현재 카메라가 커버하지 못하는 구간이면 새로 카메라 설치
            if (e < route[0]) {
                answer++;
                e = route[1];
            } else {
                // 현재 구간의 끝 지점과 비교하여 최소값으로 업데이트
                e = Math.min(e, route[1]);
            }
        }

        return answer;
    }

    // 종료 지점을 기준으로 카메라 설치
    public int endSolution(int[][] routes) {
        // 종료 지점을 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int answer = 0; // 설치된 카메라의 수
        int e = Integer.MIN_VALUE; // 현재 설치된 카메라의 위치

        for (int[] route : routes) {
            // 현재 카메라가 커버하지 못하는 구간이면 새로 카메라 설치
            if (e < route[0]) {
                answer++;
                e = route[1];
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 종료 지점을 기준으로 카메라 설치하여 결과 출력
        System.out.println(s.endSolution(new int[][]{{-13, 0}, {-11, -8}, {-7, -6}, {-4, -2}}));
        // 시작 지점을 기준으로 카메라 설치하여 결과 출력
        System.out.println(s.startSolution(new int[][]{{-13, 0}, {-11, -8}, {-7, -6}, {-5, -2}}));
    }
}
