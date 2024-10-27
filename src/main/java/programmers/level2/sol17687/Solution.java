package programmers.level2.sol17687;

/**
 * 프로그래머스 Level.2 N진수 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 **/
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();  // 전체 숫자 문자열을 저장할 StringBuilder
        StringBuilder answer = new StringBuilder();  // 튜브의 답을 저장할 StringBuilder

        // 필요한 숫자의 길이를 충족할 때까지 숫자를 N진수 문자열로 변환하여 sb에 추가
        for(int i = 0; sb.length() <= t * m; i++){
            sb.append(Integer.toString(i, n));
        }

        // 튜브의 순서에 맞는 숫자를 answer에 추가
        for (int j = p - 1; answer.length() < t; j += m) {
            answer.append(sb.charAt(j));
        }

        // 정답을 대문자로 변환하여 반환
        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예제 입력: 진법 n=16, 구할 숫자의 개수 t=16, 참가 인원 m=2, 튜브의 순서 p=2
        System.out.println(s.solution(16, 16, 2, 2));  // 예제 출력 예상: "13579BDF01234567"
    }
}
