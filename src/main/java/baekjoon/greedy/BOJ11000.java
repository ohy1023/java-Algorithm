package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * 백준 11000 강의실 배정 (골드 5) - 그리디
 * https://www.acmicpc.net/problem/11000
 */
public class BOJ11000 {

    static class Class implements Comparable<Class> {
        int s;
        int e;

        public Class(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Class o) {
            if (s == o.s) return Integer.compare(this.e, o.e);
            else return Integer.compare(this.s, o.s);
        }
    }

    static PriorityQueue<Class> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new Class(s, e));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        while (!pq.isEmpty()) {
            Class curClass = pq.poll();

            if (room.peek() <= curClass.s) room.poll();
            room.offer(curClass.e);
        }

        System.out.println(room.size());
    }
}
