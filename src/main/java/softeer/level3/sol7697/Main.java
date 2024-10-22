package softeer.level3.sol7697;

import java.io.*;
import java.util.*;

/**
 * 소프티어 Phi Squared - Deque
 * https://softeer.ai/practice/7697
 */
public class Main {
    // 미생물을 나타내는 클래스
    static class Microbe {
        int idx;   // 미생물의 초기 위치 인덱스
        long size; // 미생물의 크기

        public Microbe(int idx, long size) {
            this.idx = idx;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 미생물의 개수

        Deque<Microbe> curDeque = new LinkedList<>(); // 현재 일차에서 처리할 미생물
        Deque<Microbe> nextDeque = new LinkedList<>(); // 다음 일차로 넘어갈 미생물

        // 초기 미생물 정보 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            curDeque.offerLast(new Microbe(i + 1, Long.parseLong(st.nextToken())));
        }

        // 큐에 한 개의 미생물만 남을 때까지 반복
        while (curDeque.size() > 1) {
            while (!curDeque.isEmpty()) {
                Microbe curMicrobe = curDeque.pollFirst(); // 현재 처리할 미생물
                long curSize = curMicrobe.size;

                // 다음 일차 미생물 큐에 있는 미생물이 현재 미생물보다 작은 경우 합치기
                if (!nextDeque.isEmpty() && nextDeque.peekLast().size <= curMicrobe.size) {
                    Microbe lastMicrobe = nextDeque.pollLast();
                    curSize += lastMicrobe.size;
                }

                // 현재 일차 미생물 큐에 있는 다음 미생물이 현재 미생물보다 작은 경우 합치기
                if (!curDeque.isEmpty() && curDeque.peekFirst().size <= curMicrobe.size) {
                    Microbe firstMicrobe = curDeque.pollFirst();
                    curSize += firstMicrobe.size;
                }

                // 합쳐진 결과를 다음 일차 큐에 추가
                nextDeque.addLast(new Microbe(curMicrobe.idx, curSize));
            }

            // 다음 일차 준비
            curDeque = nextDeque;
            nextDeque = new LinkedList<>();
        }

        // 최종 남은 미생물 정보 출력
        Microbe answer = curDeque.pollFirst();
        System.out.println(answer.size); // 남은 미생물의 크기
        System.out.println(answer.idx);  // 남은 미생물의 초기 인덱스
    }
}
