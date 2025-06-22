package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10845 큐 (실버 4) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/10845">...</a>
 */
public class BOJ10845 {

    static int size;
    static int[] queue;

    static void push(int value) {
        queue[size] = value;
        size++;
    }

    static int pop() {
        if (size == 0) return -1;
        int value = queue[0];
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--;
        return value;
    }

    static int size() {
        return size;
    }

    static int empty() {
        return size == 0 ? 1 : 0;
    }

    static int front() {
        return size == 0 ? -1 : queue[0];
    }

    static int back() {
        return size == 0 ? -1 : queue[size - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        queue = new int[N];
        size = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
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
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
