package programmers.level2.sol172927;

import java.util.*;

/**
 * 프로그래머스 level 2 광물 캐기 - 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=java#
 */
class Solution {

    /**
     * 주어진 곡괭이로 광물을 캐는 최소 피로도를 반환하는 메소드
     *
     * @param picks    다이아몬드, 철, 돌 곡괭이의 개수를 담은 배열
     * @param minerals 캐기 위한 광물들의 배열
     * @return 캐는 최소 피로도
     */
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 다이아몬드, 철, 돌 곡괭이의 개수
        int diamondPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];

        // 캐야 할 총 광물의 개수
        int targetLength = 5 * (diamondPick + ironPick + stonePick);

        // targetLength가 minerals의 길이보다 클 경우, 최대 길이를 설정
        String[] trimmedMinerals = new String[Math.min(targetLength, minerals.length)];
        System.arraycopy(minerals, 0, trimmedMinerals, 0, trimmedMinerals.length);

        // 광물을 담을 리스트
        ArrayList<Map<String, Integer>> mapList = new ArrayList<>();
        int size = trimmedMinerals.length / 5;

        // 5개의 광물을 하나의 맵으로 묶어 리스트에 추가
        for (int i = 0; i < size; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                String mineral = trimmedMinerals[j + (i * 5)];
                map.put(mineral, map.getOrDefault(mineral, 0) + 1);
            }
            mapList.add(map);
        }

        // 남은 광물이 5개 미만인 경우 따로 처리
        if (trimmedMinerals.length % 5 != 0) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = size * 5; i < trimmedMinerals.length; i++) {
                String mineral = trimmedMinerals[i];
                map.put(mineral, map.getOrDefault(mineral, 0) + 1);
            }
            mapList.add(map);
        }

        // 다이아몬드, 철, 돌 곡괭이를 기준으로 맵 리스트를 정렬
        Collections.sort(mapList, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                int diamond1 = o1.getOrDefault("diamond", 0);
                int iron1 = o1.getOrDefault("iron", 0);
                int stone1 = o1.getOrDefault("stone", 0);

                int diamond2 = o2.getOrDefault("diamond", 0);
                int iron2 = o2.getOrDefault("iron", 0);
                int stone2 = o2.getOrDefault("stone", 0);

                if (diamond1 != diamond2) {
                    return diamond2 - diamond1;
                } else if (iron1 != iron2) {
                    return iron2 - iron1;
                } else {
                    return stone2 - stone1;
                }
            }
        });

        // 곡괭이에 맞춰 광물 캐기
        for (Map<String, Integer> map : mapList) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String mineral = entry.getKey();
                int count = entry.getValue();

                if (mineral.equals("diamond")) {
                    answer += Math.min(diamondPick, count);
                    diamondPick = Math.max(0, diamondPick - count);
                } else if (mineral.equals("iron")) {
                    answer += Math.min(ironPick, count);
                    ironPick = Math.max(0, ironPick - count);
                } else {
                    answer += Math.min(stonePick, count);
                    stonePick = Math.max(0, stonePick - count);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{0, 0, 1}, new String[]{"stone", "stone", "stone", "stone", "stone", "diamond"}));
    }
}
