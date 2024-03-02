package baekjoon.sorting;

import java.io.*;
import java.util.*;

/**
 * 백준 14567 선수과목 (골드 5) - 위상정렬
 * https://acmicpc.net/problem/14567
 */
public class BOJ14567 {
    static int N, M; // 과목 수와 선수 조건의 개수
    static int[] inDegree, result; // 각 과목의 진입 차수와 결과를 저장할 배열
    static ArrayList<ArrayList<Integer>> graph; // 그래프를 표현할 리스트
    static StringBuilder sb; // 출력할 결과를 저장할 StringBuilder

    // 위상 정렬을 수행하는 메소드
    public static void topologySort() {
        Queue<int[]> q = new LinkedList<>(); // 큐를 이용한 위상 정렬 진행

        // 진입 차수가 0인 과목들을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(new int[]{i, 1}); // 과목 번호와 해당 과목까지의 학기 수(초기값: 1) 삽입
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] info = q.poll(); // 큐에서 과목 번호와 학기 정보를 가져옴
            int idx = info[0]; // 과목 번호
            int semester = info[1]; // 해당 과목까지의 학기 수
            result[idx] = semester; // 결과 배열에 저장

            // 해당 과목을 듣고 나서 들어갈 수 있는 과목들의 진입 차수 감소
            for (int subject : graph.get(idx)) {
                inDegree[subject]--;

                // 진입 차수가 0이 되면 큐에 새로 추가
                if (inDegree[subject] == 0) {
                    q.offer(new int[]{subject, semester + 1}); // 다음 학기이므로 학기 수 증가하여 큐에 삽입
                }
            }
        }

        // 결과를 StringBuilder에 저장
        for (int i = 1; i <= N; i++) sb.append(result[i]).append(' ');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 과목 수 입력
        M = Integer.parseInt(st.nextToken()); // 선수 조건의 개수 입력

        inDegree = new int[N + 1]; // 진입 차수 배열 초기화
        result = new int[N + 1]; // 결과 배열 초기화

        graph = new ArrayList<>(); // 그래프 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 노드에 대한 리스트 생성
        }

        // 선수 조건 입력과 진입 차수 계산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // a를 듣기 위해선 b를 들어야 함
            inDegree[b]++; // b의 진입 차수 증가
        }

        topologySort(); // 위상 정렬 수행

        // 결과 출력
        System.out.println(sb);
    }
}
