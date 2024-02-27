package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 4659 비밀번호 발음하기 (실버 5) - 구현
 * https://www.acmicpc.net/problem/4659
 */
public class BOJ4659 {

    /**
     * 주어진 문자가 모음인지 확인하는 메서드
     *
     * @param c 확인할 문자
     * @return 모음이면 true, 아니면 false
     */
    public static boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String acc = "> is acceptable.\n"; // 비밀번호가 조건을 만족할 때의 출력 문자열
        String not = "> is not acceptable.\n"; // 비밀번호가 조건을 만족하지 않을 때의 출력 문자열
        StringBuilder sb = new StringBuilder(); // 결과를 담을 StringBuilder

        while (true) {
            String password = br.readLine(); // 비밀번호 입력
            if (password.equals("end")) { // 종료 조건인 "end"일 경우 반복 종료
                break;
            }

            boolean flag = false; // 조건 만족 여부를 나타내는 플래그
            int count = 0; // 연속된 문자 개수를 세는 변수
            char prevChar = '.'; // 이전 문자를 저장하는 변수, 처음에는 임의의 값으로 설정

            for (char c : password.toCharArray()) { // 비밀번호의 각 문자에 대해 반복
                if (checkVowel(c)) flag = true; // 모음인 경우 플래그를 true로 설정

                if (checkVowel(prevChar) != checkVowel(c)) { // 이전 문자와 현재 문자의 모음 여부가 다른 경우
                    count = 1; // 연속된 문자 개수를 1로 초기화
                } else { // 이전 문자와 현재 문자의 모음 여부가 같은 경우
                    count++; // 연속된 문자 개수를 1 증가
                }

                if (count > 2 || (prevChar == c && prevChar != 'e' && prevChar != 'o')) { // 연속된 문자가 3개 이상이거나, 직전 문자와 같을 때(ee 또는 oo가 포함되지 않은 경우)
                    flag = false; // 조건을 만족하지 않으므로 플래그를 false로 설정
                    break; // 반복문 종료
                }

                prevChar = c; // 현재 문자를 이전 문자로 설정
            }

            if (flag) { // 조건을 만족하는 경우
                sb.append("<").append(password).append(acc); // 결과 문자열에 조건을 만족하는 메시지 추가
            } else { // 조건을 만족하지 않는 경우
                sb.append("<").append(password).append(not); // 결과 문자열에 조건을 만족하지 않는 메시지 추가
            }
        }

        System.out.println(sb); // 결과 출력
    }
}
