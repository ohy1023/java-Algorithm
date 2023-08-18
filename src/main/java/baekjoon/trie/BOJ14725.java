package baekjoon.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 백준 9342 개미굴 골드 3 - 트라이를 사용한 풀이
 */
public class BOJ14725 {
    static Trie root;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        root = new Trie();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node node = root.node;
            for (int j = 0; j < k; j++) {
                node = node.down.computeIfAbsent(st.nextToken(), s -> new Node());
            }
        }
        root.node.print(0);

        System.out.println(sb);
    }

    static class Trie {
        Node node;

        Trie() {
            node = new Node();
        }

    }

    static class Node {
        Map<String, Node> down;

        Node() {
            down = new TreeMap();
        }

        public void print(int depth) {
            for (String s : down.keySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(s).append("\n");
                down.get(s).print(depth + 1);
            }
        }
    }
}
