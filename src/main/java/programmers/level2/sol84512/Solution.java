package programmers.level2.sol84512;

import java.util.*;

/**
 * 프로그래머스 Level.2 모음 사전 - 완전 탐색
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 **/
class Solution {

    static String[] vowels;  // 모음 배열
    static List<String> words;  // 모든 가능한 단어를 저장할 리스트

    public int solution(String word) {
        int answer = 0;
        vowels = new String[]{"A", "E", "I", "O", "U"};  // 모음 초기화

        words = new ArrayList<>();  // 리스트 초기화

        // 각 모음으로 시작하는 단어들을 생성하여 리스트에 추가
        for (int i = 0; i < vowels.length; i++) {
            makeDictionary(vowels[i], 1);
        }

        // 리스트에서 원하는 단어의 위치를 찾아서 반환
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word)) {
                answer = i + 1;  // 인덱스는 0부터 시작하므로 +1
                break;
            }
        }
        return answer;
    }

    // 재귀적으로 단어를 생성하여 리스트에 추가하는 메서드
    public void makeDictionary(String str, int depth) {
        words.add(str);  // 현재 단어를 리스트에 추가

        if (depth == 5) {  // 최대 깊이(단어 길이)가 5가 되면 종료
            return;
        }

        // 현재 단어에 각 모음을 추가하여 새로운 단어를 생성하고 재귀 호출
        for (int i = 0; i < vowels.length; i++) {
            makeDictionary(str + vowels[i], depth + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("AAAEA"));
        System.out.println(s.solution("I"));
    }
}
