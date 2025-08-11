package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 20006 랭킹전 대기열 (실버 2) - 구현
 * <a href="https://www.acmicpc.net/problem/20006">...</a>
 */
public class BOJ20006 {

    static class Player implements Comparable<Player> {

        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Player player = new Player(level, nickname);
            boolean entered = false;

            for (List<Player> room : rooms) {
                int baseline = room.get(0).level;


                if (Math.abs(baseline - level) <= 10 && room.size() < m) {
                    room.add(player);
                    entered = true;
                    break;
                }

            }

            if (!entered) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                rooms.add(newRoom);
            }

        }

        for (List<Player> room : rooms) {
            if (room.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            Collections.sort(room);

            for (Player player : room) {
                System.out.println(player);
            }
        }
    }
}
