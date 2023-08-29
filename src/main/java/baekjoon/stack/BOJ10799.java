package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 10799 쇠막대기 실버 2 - 스택을 사용한 풀이
 */
public class BOJ10799 {

    public static int solution(String line) {
        int res = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (line.charAt(i - 1) == '(') {
                    res += stack.size();
                } else {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();


        System.out.println(solution(line));

    }
}
