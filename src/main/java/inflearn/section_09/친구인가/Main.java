package inflearn.section_09.친구인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인프런 친구인가? - Disjoint Set(Union-Find)
 */
public class Main {

    static int N, M;
    static int[] parent;

    /**
     * 부모를 찾는 메서드입니다.
     *
     * @param x 부모를 찾을 노드
     * @return a의 부모 노드
     */
    public static int findParent(int x) {
        if (x != parent[x]) {
            return findParent(parent[x]);
        }
        return parent[x];
    }

    /**
     * 두 노드를 연결하는 메서드입니다.
     *
     * @param a 연결할 노드
     * @param b 연결할 노드
     */
    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 부모 배열 초기화
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        // 친구 관계 입력 및 Union 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findParent(a) != findParent(b)) {
                union(a, b);
            }
        }

        // 확인할 두 노드 입력 및 부모가 같은지 확인하여 결과 출력
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (findParent(a) != findParent(b)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
