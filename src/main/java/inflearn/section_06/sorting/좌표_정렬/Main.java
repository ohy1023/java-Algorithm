package inflearn.section_06.sorting.좌표_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 인프런 알고리즘 강의
 * 좌표 정렬 - 정렬
 */

class Point implements Comparable<Point> {

    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        // 두 Point 객체를 비교하여 정렬 순서를 결정하는 메서드
        if (this.x == o.x) {
            // x 좌표가 같을 경우, y 좌표를 오름차순으로 정렬
            return this.y - o.y;
        } else {
            // x 좌표가 다를 경우, x 좌표를 오름차순으로 정렬
            return this.x - o.x;
        }
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> arr = new ArrayList<>();
        StringTokenizer st;

        // 입력된 좌표를 Point 객체로 생성하여 리스트에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 좌표를 정렬
        Collections.sort(arr);

        // 정렬된 좌표 출력
        for (Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
