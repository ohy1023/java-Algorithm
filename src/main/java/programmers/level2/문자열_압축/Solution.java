package programmers.level2.문자열_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 프로그래머스 level 2 문자열 압축 - 구현
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */

class Solution {
    public int solution(String s) {
        // 최종 압축 결과의 길이를 초기화
        int answer = s.length();

        // 문자열을 자를 길이를 1부터 s.length() / 2까지 시도
        for (int i = 1; i <= s.length() / 2; i++) {
            // 임시 문자열을 저장할 StringBuilder 생성
            StringBuilder tmp = new StringBuilder();
            // 이전에 비교한 부분 문자열을 저장하는 변수
            String prev = s.substring(0, i);
            // 연속된 부분 문자열의 개수를 세는 변수
            int cnt = 1;

            // 문자열을 i 길이만큼씩 자르면서 비교
            for (int j = i; j < s.length(); j += i) {
                // 현재 부분 문자열
                String subString = (j + i <= s.length()) ? s.substring(j, j + i) : s.substring(j);
                // 이전 부분 문자열과 같으면 개수 증가
                if (prev.equals(subString)) {
                    cnt++;
                } else {
                    // 이전 부분 문자열과 다르면, 결과 문자열에 추가
                    if (cnt >= 2) {
                        tmp.append(cnt);
                    }
                    tmp.append(prev);
                    // 다음 비교를 위해 이전 부분 문자열 갱신
                    prev = subString;
                    // 연속된 부분 문자열 개수 초기화
                    cnt = 1;
                }
            }
            // 마지막 부분 문자열을 처리
            if (cnt >= 2) {
                tmp.append(cnt);
            }
            tmp.append(prev);

            // 현재 압축 결과의 길이가 최소 길이인지 확인하고 업데이트
            if (answer > tmp.length()) {
                answer = tmp.length();
            }
        }

        // 최소 길이 반환
        return answer;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받는 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 문자열
        String s = br.readLine();
        Solution solution = new Solution();
        // 압축 결과 출력
        System.out.println(solution.solution(s));
    }
}
