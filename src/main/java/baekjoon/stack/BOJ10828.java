package baekjoon.stack;

import java.io.*;

/**
 * 백준 10828 스택 - 자료 구조
 * <a href="https://www.acmicpc.net/problem/10828">...</a>
 */
public class BOJ10828 {

    static int[] stack;
    static int size;

    static void push(int value) {
        stack[size] = value;
        size++;
    }

    static int top() {
        if (size == 0) return -1;
        return stack[size - 1];
    }

    static int size() {
        return size;
    }

    static int pop() {
        if (size == 0) return -1;
        int value = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return value;
    }

    static int empty() {
        if (size == 0) return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];
        size = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] command = line.split(" ");

            switch (command[0]) {
                case "push":
                    int value = Integer.parseInt(command[1]);
                    push(value);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);


    }

}
