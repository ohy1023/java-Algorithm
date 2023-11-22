package inflearn.section_04.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;


/**
 * 인프런 K번쨰 큰 수 - TreeSet
 */
public class Main {

    // n개의 카드 중에서 3장을 선택하여 만들 수 있는 모든 조합의 합 중에서 k번째로 큰 수를 반환하는 메서드
    public int solution(int n, int k, int[] cards) {
        // TreeSet을 사용하여 내림차순으로 정렬된 집합을 유지
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        // 모든 카드 조합의 합을 TreeSet에 저장
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    treeSet.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }

        // TreeSet에서 k번째 값을 꺼내 반환
        int result = 0;
        try {
            for (int i = 0; i < k; i++) {
                result = treeSet.pollFirst(); // pollFirst() 메서드는 TreeSet에서 첫 번째 값을 제거하고 반환합니다.
            }
        } catch (NullPointerException e) {
            // NullPointerException이 발생하면 -1을 반환
            result = -1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] cards = new int[N];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();

        // 결과 출력
        System.out.println(T.solution(N, K, cards));
    }
}
