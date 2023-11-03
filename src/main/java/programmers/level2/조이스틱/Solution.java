package programmers.level2.조이스틱;

/**
 * 프로그래머스 레벨 2 조이스틱 문제 - 그리디 알고리즘
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
class Solution {

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용하는 인덱스
        int move = length - 1; // 좌우 움직임 수를 체크하기 위한 변수

        // 문자열 'name'의 각 문자를 순회
        for (int i = 0; i < length; i++) {
            // 필요한 최소 이동 횟수를 계산
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;

            // 다음 'A'가 아닌 문자를 찾아 최소 이동 횟수를 계산
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 좌우 이동에 필요한 최소 이동 횟수 계산
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }

        // 최소 문자 변경 이동 횟수와 좌우 이동 횟수를 합산하여 반환
        return answer + move;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("JEROEN"));
    }
}
