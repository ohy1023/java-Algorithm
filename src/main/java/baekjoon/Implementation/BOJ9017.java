package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 9017 크로스 컨트리 (실버 3) - 구현
 * <a href="https://www.acmicpc.net/problem/9017">...</a>
 */
public class BOJ9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
            int maxTeamNum = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                countMap.put(team, countMap.getOrDefault(team, 0) + 1);
                rank[j] = team;
                maxTeamNum = Math.max(maxTeamNum, team);
            }

            Map<Integer, Integer> scoreMap = new HashMap<>();
            int[] fifth = new int[maxTeamNum + 1];
            int[] playerCount = new int[maxTeamNum + 1];

            int score = 1;
            for (int r : rank) {
                if (countMap.get(r) == 6) {
                    int count = playerCount[r]++;
                    if (count < 4) {
                        scoreMap.put(r, scoreMap.getOrDefault(r, 0) + score);
                    } else if (count == 4) {
                        fifth[r] = score;
                    }
                    score++;
                }
            }

            int minScore = Integer.MAX_VALUE;
            int answer = -1;

            for (int team : scoreMap.keySet()) {
                int teamScore = scoreMap.getOrDefault(team, 0);

                if (minScore > teamScore) {
                    minScore = teamScore;
                    answer = team;
                } else if (minScore == teamScore) {
                    if (fifth[team] < fifth[answer]) answer = team;
                }
            }

            sb.append(answer).append("\n");
        }


        System.out.println(sb);

    }
}