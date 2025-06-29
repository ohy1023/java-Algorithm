package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 1874 스택 수열 (실버 2) - 자료 구조
 * https://www.acmicpc.net/problem/1874
 */
public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int last = 0;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (last < target) {
                stack.push(++last);
                sb.append("+").append("\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
