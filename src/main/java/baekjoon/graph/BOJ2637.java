package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2637 장난감 조립 (골드 2) - 위상 정렬
 * https://www.acmicpc.net/problem/2637
 */

public class BOJ2637 {
    static class Part {
        int part;
        int count;

        public Part(int part, int count) {
            this.part = part;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 부품의 개수
        int[] basicParts = new int[N + 1]; // 기본 부품의 개수를 저장하는 배열
        int[] indegree = new int[N + 1];
        List<List<Part>> relationships = new ArrayList<>(); // 부품 간의 관계를 저장하는 리스트

        for (int i = 0; i <= N; i++) {
            relationships.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine()); // 관계의 개수

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            relationships.get(Y).add(new Part(X, K)); // 관계 정보 저장
            indegree[X]++;
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        // 위상 정렬을 위한 초기화
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상 정렬 진행
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Part relation : relationships.get(node)) {
                int parent = relation.part;
                int count = relation.count;

                basicParts[parent] += basicParts[node] * count;


                if (--indegree[parent] == 0) {
                    queue.add(parent);
                }
            }
        }

        // 기본 부품의 번호와 소요 개수 출력
        for (int i = 1; i <= N; i++) {
            if (basicParts[i] > 0) {
                System.out.println(i + " " + basicParts[i]);
            }
        }
    }
}