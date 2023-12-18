package programmers.level2.영어_끝말잇기;

import java.util.ArrayList;

/**
 * 프로그래머스 레벨 2. 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
class Solution {
    // 게임 중 사용된 단어를 저장하기 위한 ArrayList
    private ArrayList<String> usedWords;

    // 단어가 게임 규칙에 맞는지 확인하는 메서드
    public boolean checkWord(String word) {
        // 이미 사용된 단어인 경우 유효하지 않음
        if (usedWords.contains(word)) {
            return false;
        }

        // 이전 단어가 있을 경우, 현재 단어가 이전 단어의 끝 글자로 시작하는지 확인
        if (!usedWords.isEmpty()) {
            String lastWord = usedWords.get(usedWords.size() - 1);
            char lastChar = lastWord.charAt(lastWord.length() - 1);
            char curChar = word.charAt(0);

            // 끝 글자가 일치하지 않으면 유효하지 않음
            if (lastChar != curChar) {
                return false;
            }
        }

        // 위의 모든 조건을 통과하면 단어가 유효함
        return true;
    }

    // 게임의 정답을 찾기 위한 메서드
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        usedWords = new ArrayList<>();

        int count = 0;

        // 배열의 각 단어에 대해 반복
        for (String word : words) {
            // 단어가 유효한지 확인
            if (!checkWord(word)) {
                // 유효하지 않으면 정답 설정하고 반복문 종료
                answer[0] = count % n + 1;  // 차례가 몇 번째 사람인지 (1부터 시작)
                answer[1] = count / n + 1;  // 몇 번째 차례인지 (1부터 시작)
                break;
            }

            // 유효한 단어를 사용된 단어 목록에 추가
            usedWords.add(word);

            // 차례를 증가
            count++;
        }

        // 정답 반환
        return answer;
    }

    // 솔루션을 테스트하기 위한 메인 메서드
    public static void main(String[] args) {
        Solution s = new Solution();
        // 솔루션 메서드의 예제 사용
        int[] solution = s.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        // 결과 출력
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
