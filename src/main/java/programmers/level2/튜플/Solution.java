package programmers.level2.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스 튜플 (level.2) - 문자열
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 1. 문자열을 배열로 변환
        String substring = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] split = substring.split("-");

        // 2. 배열을 길이 기준으로 정렬
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 3. 배열을 순회하며 중복 없이 정수를 리스트에 추가
        for (String str : split) {
            String[] temp = str.split(",");
            for (int i = 0; i < temp.length; i++) {
                int n = Integer.parseInt(temp[i]);
                if (!answer.contains(n)) {
                    answer.add(n);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }
}
