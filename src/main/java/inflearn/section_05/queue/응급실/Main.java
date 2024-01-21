package inflearn.section_05.queue.응급실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인프런 Section 5
 * 응급실 - Queue
 */
public class Main {

    static Queue<Patient> queue; // 환자 정보를 저장하는 큐

    static int N, M; // 전체 환자 수와 처리 대상 환자의 번호

    static class Patient {
        private int idx;   // 환자의 번호
        private int risk;  // 환자의 우선순위

        public Patient(int idx, int risk) {
            this.idx = idx;
            this.risk = risk;
        }
    }

    /**
     * 응급실에서 처리되는 순서를 계산하는 메서드
     *
     * @return 처리되는 순서의 총 개수
     */
    public static int solution() {
        int res = 0; // 처리되는 순서의 총 개수

        while (!queue.isEmpty()) { // 큐가 비어 있을 때까지 반복
            Patient patient = queue.poll(); // 큐에서 환자 하나를 꺼내기

            // 큐에 남아 있는 환자들과 우선순위를 비교하여 더 높은 우선순위가 있는지 확인
            for (Patient p : queue) {
                if (p.risk > patient.risk) {
                    queue.offer(patient); // 꺼낸 환자보다 높은 우선순위가 있으면 다시 큐에 넣기
                    patient = null; // 해당 환자는 무시
                    break;
                }
            }

            // 높은 우선순위가 없었거나, 큐를 다 돌았을 경우에만 환자 처리 순서 증가
            if (patient != null) {
                res++;
                if (patient.idx == M) {
                    return res; // 처리된 환자가 원하는 환자인 경우 종료
                }
            }
        }

        return res; // 처리된 순서 반환
    }

    /**
     * 메인 메서드
     *
     * @param args 커맨드 라인 인자 (사용하지 않음)
     * @throws IOException 입출력 예외
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 환자 수 입력
        M = Integer.parseInt(st.nextToken()); // 처리 대상 환자의 번호 입력

        st = new StringTokenizer(br.readLine());

        queue = new LinkedList<>();

        // 환자 정보를 큐에 저장
        for (int i = 0; i < N; i++) {
            queue.offer(new Patient(i, Integer.parseInt(st.nextToken())));
        }

        // 처리되는 순서 출력
        System.out.println(solution());
    }
}
