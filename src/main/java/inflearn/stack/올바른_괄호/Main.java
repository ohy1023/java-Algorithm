package inflearn.stack.올바른_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static char[] chars;
    static Stack<Character> stack;


    public static String solution() {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        chars = br.readLine().toCharArray();

        System.out.println(solution());
    }
}
