package baekjoon.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 14725 개미굴 (골드 3) - 트라이
 * https://www.acmicpc.net/problem/14725
 */
public class BOJ14725 {

    // Trie의 루트 노드
    static Trie root;

    // 노드 클래스
    static class Node {
        // 자식 노드를 담을 맵
        Map<String, Node> childNode = new TreeMap<>();

        // 현재 노드에서부터 시작하여 깊이 우선 탐색으로 모든 노드의 문자열을 출력하는 메서드
        void print(int depth) {
            for (String s : childNode.keySet()) {
                // 현재 노드의 깊이만큼 "--"를 출력
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }

                // 현재 문자열 출력
                System.out.println(s);

                // 자식 노드의 print 메서드 재귀 호출
                childNode.get(s).print(depth + 1);
            }
        }
    }

    // Trie 클래스
    static class Trie {
        // 루트 노드의 인스턴스 생성
        Node node = new Node();

        // Trie에 문자열 삽입하는 메서드
        void insert(String[] words) {
            Node cur = this.node;
            for (String word : words) {
                // 현재 문자열이 자식 노드에 없으면 새로운 노드를 생성하여 추가
                cur = cur.childNode.computeIfAbsent(word, key -> new Node());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력에서 첫 줄에 주어진 정수 n
        int n = Integer.parseInt(br.readLine());

        // Trie의 루트 노드 생성
        root = new Trie();

        // n개의 줄에 걸쳐서 각 개미굴에 대한 정보를 입력 받고 Trie에 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 현재 개미굴에 있는 문자열의 개수
            String[] words = new String[k];
            for (int j = 0; j < k; j++) {
                words[j] = st.nextToken();
            }
            // Trie에 문자열 삽입
            root.insert(words);
        }

        // Trie의 모든 노드를 깊이 우선 탐색하여 출력
        root.node.print(0);
    }
}
