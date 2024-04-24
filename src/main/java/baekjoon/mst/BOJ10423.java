package baekjoon.mst;

import java.io.*;
import java.util.*;

/**
 * 백준 전기가 부족해 (골드 3) - MST
 * https://www.acmicpc.net/problem/10423
 */
public class BOJ10423 {
    static class City implements Comparable<City> {
        private int s; // 출발 도시 번호
        private int e; // 도착 도시 번호
        private int cost; // 전선 설치 비용

        public City(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.cost, o.cost); // 비용을 기준으로 오름차순 정렬
        }
    }

    static int N; // 도시의 수
    static int[] parent; // 각 도시의 부모 노드를 저장하는 배열

    // 특정 도시의 부모 노드를 찾는 메소드
    private static int findParent(int x) {
        if (parent[x] == -1) {
            return -1;
        }

        if (x != parent[x]) {
            return findParent(parent[x]); // 재귀적으로 부모 노드를 찾음
        }

        return parent[x];
    }

    // 두 도시의 부모 노드를 합치는 메소드
    private static void unionParent(int c1, int c2) {
        int a = findParent(c1);
        int b = findParent(c2);

        if (a == -1) {
            parent[b] = -1;
        } else if (b == -1) {
            parent[a] = -1;
        } else {
            if (a > b) parent[a] = b; // 작은 번호의 도시가 부모가 되도록 함
            else parent[b] = a;
        }
    }

    // 모든 도시가 전부 연결되었는지 확인하는 메소드
    private static boolean isAllConnect() {
        for (int i = 1; i < N + 1; i++) {
            if (parent[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 수 입력
        int M = Integer.parseInt(st.nextToken()); // 전선의 수 입력
        int K = Integer.parseInt(st.nextToken()); // 발전소의 수 입력

        parent = new int[N + 1]; // 부모 노드 배열 초기화
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i; // 초기에는 각 도시가 자신을 부모로 가짐
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < K; j++) {
            int powerIdx = Integer.parseInt(st.nextToken());

            parent[powerIdx] = -1; // 발전소가 있는 도시의 부모 노드를 -1로 설정
        }

        List<City> cities = new ArrayList<>(); // 전선 정보를 저장하는 리스트

        // 전선 정보 입력 및 저장
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발 도시 번호
            int v = Integer.parseInt(st.nextToken()); // 도착 도시 번호
            int w = Integer.parseInt(st.nextToken()); // 전선 설치 비용

            cities.add(new City(u, v, w)); // 전선 정보를 리스트에 추가
        }

        Collections.sort(cities); // 전선 설치 비용을 기준으로 오름차순 정렬

        int res = 0; // 최종 결과를 저장하는 변수

        // MST를 구성하면서 최소 비용 계산
        for (City city : cities) {
            if (findParent(city.s) != findParent(city.e)) { // 두 도시의 부모 노드가 다를 경우
                unionParent(city.s, city.e); // 두 도시를 연결하고
                res += city.cost; // 전선 설치 비용을 더함

                if (isAllConnect()) { // 모든 도시가 전부 연결되었는지 확인
                    break; // 연결되었다면 반복 종료
                }
            }
        }

        System.out.println(res); // 최종 결과 출력
    }
}
