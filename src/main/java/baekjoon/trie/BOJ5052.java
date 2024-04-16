package baekjoon.trie;

import java.io.*;
import java.util.*;

/**
 * 백준 5052 전화번호 목록 (골드 4) - 트라이
 * https://www.acmicpc.net/problem/5052
 */
public class BOJ5052 {

    static Trie trie;

    static class Node {
        Map<Character, Node> childNode;
        boolean isEnd;

        public Node() {
            childNode = new HashMap<>();
            isEnd = false;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        void insert(String phoneNumber) {
            Node node = this.root;

            for (int i = 0; i < phoneNumber.length(); i++) {
                node = node.childNode.computeIfAbsent(phoneNumber.charAt(i), key -> new Node());
            }

            node.isEnd = true;
        }

        boolean isConsistent(List<String> phoneNumbers) {
            for (String phoneNumber : phoneNumbers) {
                Node node = this.root;
                for (int i = 0; i < phoneNumber.length(); i++) {
                    node = node.childNode.getOrDefault(phoneNumber.charAt(i), null);
                    if (node == null) {
                        return false;
                    }
                    if (node.isEnd && i < phoneNumber.length() - 1) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<String> keys = new ArrayList<>();
            trie = new Trie();
            for (int j = 0; j < n; j++) {
                String phoneNumber = br.readLine();
                trie.insert(phoneNumber);
                keys.add(phoneNumber);
            }

            sb.append(trie.isConsistent(keys) ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }
}
