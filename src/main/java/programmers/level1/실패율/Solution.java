package programmers.level1.실패율;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스 level 1 실패율 - 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */

public class Solution {

    public List<Integer> solution(int N, int[] stages) {
        // 각 스테이지별 실패율을 저장할 HashMap을 생성합니다.
        HashMap<Integer, Double> hashMap = new HashMap();

        // 스테이지별 플레이어 도달 정보를 담을 배열을 생성합니다.
        int[] info = new int[N + 2];

        // 스테이지별 플레이어 도달 정보를 계산합니다.
        for (int stage : stages) {
            info[stage] += 1;
        }

        // 스테이지별 실패율을 계산합니다.
        for (int i = 1; i <= N; i++) {
            if (info[i] != 0) {
                int value = info[i];

                // 스테이지에 도달한 전체 플레이어 수를 계산합니다.
                int totalPeople = Arrays.stream(Arrays.copyOfRange(info, i, N + 3)).sum();

                // 실패율을 계산하고 HashMap에 저장합니다.
                double p = (double) value / totalPeople;
                hashMap.put(i, p);
            } else {
                // 스테이지에 도달한 플레이어가 없을 경우 실패율을 0으로 저장합니다.
                hashMap.put(i, 0.0);
            }
        }

        // 실패율을 내림차순으로 정렬하고 스테이지 번호를 오름차순으로 정렬하여 결과를 반환합니다.
        return hashMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey) // 키만 선택
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }
}
