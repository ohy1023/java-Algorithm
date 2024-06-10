package programmers.level2.sol131701;

import java.util.*;

/**
 * 프로그래머스 Level.2 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
class Solution {
    // 첫 번째 방법: 배열을 두 번 반복하여 연속 부분 배열을 구함
    public int solution(int[] elements) {
        // 중복 없는 합계 저장을 위한 Set
        Set<Integer> set = new HashSet<>();

        // 요소들을 두 번 반복해서 저장하기 위한 리스트
        ArrayList<Integer> elst = new ArrayList<>();

        // 원본 배열을 두 번 리스트에 추가하여 연속 부분 배열의 원형 순환을 가능하게 함
        for (int i = 0; i < 2; i++) {
            for (int element : elements) {
                elst.add(element);
            }
        }

        // 각 시작 위치에 대해 모든 연속 부분 배열의 합을 계산
        for (int i = 0; i < elements.length; i++) {
            // 부분 배열의 길이를 1부터 elements 길이까지 반복
            for (int j = 1; j <= elements.length; j++) {
                // 부분 배열을 추출
                List<Integer> subList = elst.subList(i, i + j);
                int tmp = 0;
                // 부분 배열의 합을 계산
                for (int num : subList) {
                    tmp += num;
                }
                // 합을 Set에 추가하여 중복된 값을 걸러냄
                set.add(tmp);
            }
        }

        // 중복 없는 합계의 개수를 반환
        return set.size();
    }

    // 두 번째 방법: 원형 배열로 연속 부분 배열을 구함
    public int solution2(int[] elements) {
        // 중복 없는 합계 저장을 위한 Set
        Set<Integer> set = new HashSet<>();

        // 각 시작 위치에 대해 모든 연속 부분 배열의 합을 계산
        for (int i = 0; i < elements.length; i++) {
            // 부분 배열의 길이를 1부터 elements 길이까지 반복
            for (int j = 1; j <= elements.length; j++) {

                int sum = 0;
                // 부분 배열의 합을 계산
                for (int k = i; k < i + j; k++) {
                    // 원형 배열의 인덱스를 사용하여 값 추가
                    sum += elements[k % elements.length];
                }

                // 합을 Set에 추가하여 중복된 값을 걸러냄
                set.add(sum);
            }
        }

        // 중복 없는 합계의 개수를 반환
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 첫 번째 방법 테스트
        System.out.println(s.solution(new int[]{7, 9, 1, 1, 4}));
        // 두 번째 방법 테스트
        System.out.println(s.solution2(new int[]{7, 9, 1, 1, 4}));
    }
}
