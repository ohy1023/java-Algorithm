package programmers.level2.캐시;

import java.util.*;

/**
 * 프로그래머스 level 2 캐시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
class Solution {
    // 캐시 히트 및 미스에 대한 비용 상수 정의
    private final int CACHE_HIT = 1;
    private final int CACHE_MISS = 5;

    /**
     * 주어진 캐시 사이즈와 도시 배열에 대해 최소 비용을 계산하는 메서드
     *
     * @param cacheSize 캐시 크기
     * @param cities    도시 배열
     * @return 최소 비용
     */
    public int solution(int cacheSize, String[] cities) {
        // 캐시 사이즈가 0이면 모든 경우에서 히트 미스가 발생
        if (cacheSize == 0) {
            return CACHE_MISS * cities.length;
        }

        int answer = 0;

        // 캐시를 관리하는 LinkedList
        LinkedList<String> cache = new LinkedList<>();

        // 주어진 도시 배열을 순회하며 캐시 히트 및 미스를 계산
        for (int i = 0; i < cities.length; i++) {
            // 대소문자를 구별하지 않기 위해 소문자로 통일
            String city = cities[i].toLowerCase();

            // 캐시에서 도시를 찾아 히트 여부를 판단하고 비용을 계산
            if (cache.remove(city)) {
                // 히트인 경우 해당 도시를 캐시 맨 앞으로 이동
                cache.addFirst(city);
                answer += CACHE_HIT;
            } else {
                // 미스인 경우 캐시가 가득 차있다면 가장 오래된 도시를 제거
                if (cache.size() == cacheSize) {
                    cache.pollLast();
                }

                // 새로운 도시를 캐시 맨 앞에 추가하고 미스 비용을 계산
                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int cacheSize = 3;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(s.solution(cacheSize, cities));
    }
}
