package inflearn.section_05.stack.교육과정_설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 인프런 Section 5
 * 교육과정 설계 - Stack
 */
public class Main {

    /**
     * 교육과정 설계를 확인하는 메서드
     *
     * @param rule         교육과정 규칙을 나타내는 문자열
     * @param mySchedule   개인 학습 일정을 나타내는 문자열
     * @return             개인 학습 일정이 교육과정 규칙에 부합하는지 여부 (YES 또는 NO)
     */
    public static boolean solution(String rule, String mySchedule) {
        Stack<Character> stack = new Stack<>();

        // 교육과정 규칙을 스택에 넣기
        for (char c : rule.toCharArray()) {
            stack.push(c);
        }

        // 개인 학습 일정을 확인하면서 스택과 비교
        char[] mySchedules = mySchedule.toCharArray();
        for (int i = mySchedules.length - 1; i >= 0; i--) {
            // 스택의 맨 위 값과 현재 개인 학습 일정을 비교하여 일치하면 스택에서 제거
            if (!stack.isEmpty() && mySchedules[i] == stack.peek()) {
                stack.pop();
            }
        }

        // 스택이 비어있으면 교육과정 규칙에 부합
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 교육과정 규칙과 개인 학습 일정을 입력받기
        String rule = br.readLine();
        String mySchedule = br.readLine();

        // 교육과정 설계를 확인하고 결과 출력
        if (solution(rule, mySchedule)) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
