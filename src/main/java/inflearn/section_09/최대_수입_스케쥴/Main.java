package inflearn.section_09.최대_수입_스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 인프런 - 최대 수입 스케쥴 - 그리디
 */
public class Main {

    static class Lecture implements Comparable<Lecture> {

        int pay; // 강의 수입을 나타내는 변수
        int day; // 강의 기간을 나타내는 변수

        public Lecture(int income, int day) {
            this.pay = income;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            // 기간을 기준으로 내림차순 정렬
            return Integer.compare(o.day, this.day);
        }
    }

    static int N, max = Integer.MIN_VALUE;

    /**
     * 강의 스케쥴을 최대로 선택하여 얻을 수 있는 최대 수입을 계산하는 메서드
     *
     * @param lectures 강의 스케쥴 정보를 담고 있는 리스트
     * @return 최대 수입
     */
    public static int solution(ArrayList<Lecture> lectures) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(lectures);

        int j = 0;

        // 최대 강의 기간부터 1일까지 반복
        for (int i = max; i >= 1; i--) {
            // 현재 기간에 가능한 강의들의 수입을 우선순위 큐에 추가
            for (; j < N; j++) {
                if (lectures.get(j).day < i) {
                    break;
                }
                pq.offer(lectures.get(j).pay);
            }

            // 현재 기간에 가능한 강의 중 가장 비용이 큰 강의를 선택
            if (!pq.isEmpty()) {
                res += pq.poll();
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ArrayList<Lecture> lectures = new ArrayList<>();

        // 강의 정보 입력 및 최대 강의 기간 갱신
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(M, D));
            if (D > max) {
                max = D;
            }
        }

        // 결과 출력
        System.out.println(solution(lectures));
    }
}
