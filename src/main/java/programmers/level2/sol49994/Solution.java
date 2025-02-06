package programmers.level2.sol49994;

import java.util.*;

/**
 * 프로그래머스 방문 길이
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/49994">...</a>
 */
class Solution {
    private final Map<Character, int[]> direction = Map.of(
            'L', new int[]{-1, 0},
            'R', new int[]{1, 0},
            'U', new int[]{0, 1},
            'D', new int[]{0, -1}
    );


    static class Coordinate {
        private int sx;
        private int sy;
        private int ex;
        private int ey;

        public Coordinate(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;

            return (sx == that.sx && sy == that.sy && ex == that.ex && ey == that.ey) || (sx == that.ex && sy == that.ey && ex == that.sx && ey == that.sy);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Math.min(sx, ex), Math.min(sy, ey), Math.max(sx, ex), Math.max(sy, ey));
        }

        @Override
        public String toString() {
            return "sx : " + sx + " sy : " + sy + " ex : " + ex + " ey : " + ey;
        }

    }


    public int solution(String dirs) {

        int curX = 0;
        int curY = 0;

        Set<Coordinate> set = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] d = direction.get(dirs.charAt(i));
            if (curX + d[0] > 5 || curY + d[1] > 5 || curX + d[0] < -5 || curY + d[1] < -5) continue;
            set.add(new Coordinate(curX, curY, curX + d[0], curY + d[1]));
            curX += d[0];
            curY += d[1];
        }

        for (Coordinate coordinate : set) {
            System.out.println(coordinate.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ULURRDLLU"));
        System.out.println(s.solution("LULLLLLLU"));
    }
}