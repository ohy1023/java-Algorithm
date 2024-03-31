package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * 백준 2170 선 긋기 (골드 4) - 그리디
 * https://www.acmicpc.net/problem/2170
 */
public class BOJ2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int answer = 0;

        // 초기 시작점과 끝점
        int s = -1000000001;
        int e = -1000000001;

        // 선분 정보를 저장할 리스트
        ArrayList<int[]> info = new ArrayList<>();

        // 선분 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 선분의 시작점을 기준으로 오름차순 정렬
        info.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 선분들을 순회하면서 겹치지 않는 선분 길이 계산
        for (int[] i : info) {
            if (i[0] > e) { // 현재 선분과 이전 선분이 겹치지 않을 때
                // 이전 선분 길이를 누적하여 정답에 추가하고 새로운 시작점과 끝점 설정
                answer += e - s;
                s = i[0];
                e = i[1];
            } else { // 현재 선분과 이전 선분이 겹칠 때
                if (i[1] > e) { // 이전 선분의 끝점을 현재 선분의 끝점으로 갱신
                    e = i[1];
                }
            }
        }

        // 마지막 선분의 길이를 누적하여 정답에 추가
        System.out.println(answer + (e - s));
    }
}
