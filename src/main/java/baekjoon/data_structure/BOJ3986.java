package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 3986 좋은 단어 (실버 4) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/3986">...</a>
 */
public class BOJ3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
