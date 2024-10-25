package programmers.level2.sol17684;

import java.util.*;

/**
 * 프로그래머스 Level.2 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 **/
class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 1; i < 27; i++) {
            dictionary.put(String.valueOf((char) (64 + i)), i);
        }

        int idx = 0;
        while (idx + 1 < msg.length()) {
            String cur = "";
            String pre = String.valueOf(msg.charAt(idx));

            for (int i = 1; idx + i <= msg.length(); i++) {
                cur = msg.substring(idx, idx + i);

                if (!dictionary.containsKey(cur)) {
                    dictionary.put(cur, dictionary.size() + 1);
                    break;
                }
                pre = cur;
            }

            answer.add(dictionary.get(pre));
            idx += pre.length();
        }

        if (idx == msg.length() - 1) {
            answer.add(dictionary.get(String.valueOf(msg.charAt(idx))));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("KAKAO"));
    }


}