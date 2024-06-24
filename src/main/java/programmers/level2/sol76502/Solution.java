package programmers.level2.sol76502;

import java.util.Stack;

/**
 * 프로그래머스 Level.2 괄호 회전하기 - 스택
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
class Solution {

    static int answer;

    public void checkValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) answer++;

    }

    public int solution(String s) {
        answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String line = s.substring(i) + s.substring(0, i);

            checkValid(line);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("}]()[{"));
    }
}