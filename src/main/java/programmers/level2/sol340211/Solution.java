package programmers.level2.sol340211;

import java.util.*;

/**
 * 프로그래머스 Level.2 충돌위험 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/340211
 */
class Solution {

    static int maxR;
    static int maxC;
    static Map<Integer, Point> pointMap = new HashMap<>();

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return this.r == point.r && this.c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

    }

    public int solution(int[][] points, int[][] routes) {

        setMaxPoint(points);


        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, new Point(points[i][0], points[i][1]));
        }

        int longestRouteDist = 0;
        List<List<Point>> shortestRoutes = new ArrayList<>();
        for (int[] r : routes) {
            List<Point> route = findShortestRoute(r);

            shortestRoutes.add(route);
            longestRouteDist = (longestRouteDist < route.size()) ? route.size() : longestRouteDist;
        }

        return findStrikeCount(shortestRoutes, longestRouteDist);
    }

    public int findStrikeCount(List<List<Point>> shortestRoutes, int longestRouteDist) {
        int totalCount = 0;

        for (int i = 0; i < longestRouteDist; i++) {
            Map<Point, Integer> countMap = new HashMap<>();

            for (List<Point> shortestRoute : shortestRoutes) {
                Point point = (shortestRoute.size() > i) ? shortestRoute.get(i) : null;
                if (point != null) {
                    if (countMap.get(point) == null) {
                        countMap.put(point, 1);
                        continue;
                    }
                    countMap.put(point, countMap.get(point) + 1);
                }
            }

            for (Integer count : countMap.values()) {
                if (count > 1) {
                    totalCount += 1;
                }
            }
        }
        return totalCount;
    }

    private static List<Point> findShortestRoute(int[] routePoints) {
        List<Point> shortestRoute = new ArrayList<>();
        for (int i = 1; i < routePoints.length; i++) {
            Point start = pointMap.get(routePoints[i - 1]);
            Point end = pointMap.get(routePoints[i]);

            int r = start.r;
            int c = start.c;

            if (shortestRoute.isEmpty()) {
                shortestRoute.add(new Point(r, c));
            }

            while (r != end.r) {
                r += (r > end.r) ? -1 : 1;
                shortestRoute.add(new Point(r, c));
            }

            while (c != end.c) {
                c += (c > end.c) ? -1 : 1;
                shortestRoute.add(new Point(r, c));
            }
        }

        return shortestRoute;
    }

    private static void setMaxPoint(int[][] points) {
        int[] result = Arrays.stream(points)
                .reduce(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE},
                        (max, subArray) -> new int[]{
                                Math.max(max[0], subArray[0]),
                                Math.max(max[1], subArray[1])
                        });

        maxR = result[0];
        maxC = result[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}}));
    }
}