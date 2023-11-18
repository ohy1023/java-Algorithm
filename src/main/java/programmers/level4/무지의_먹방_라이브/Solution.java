package programmers.level4.무지의_먹방_라이브;


import java.util.Comparator;
import java.util.LinkedList;

/**
 * 프로그래머스 level 4 무지의 먹방 라이브 - 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/42891?language=java
 */
class Food {
    int time;
    int idx;

    Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }


}


class Solution {

    Comparator<Food> compTime = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.time - o2.time;
        }
    };

    Comparator<Food> compIdx = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.idx - o2.idx;
        }
    };

    public int solution(int[] food_times, long k) {
        LinkedList<Food> foods = new LinkedList<>();
        int n = food_times.length;

        for (int i = 0; i < n; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }

        foods.sort(compTime);

        int preTime = 0;
        int i = 0;
        for (Food f : foods) {
            long diff = f.time - preTime;
            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(compIdx);
                    return foods.get(i + (int) k).idx;
                }
            }
            i++;
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 1, 2}, 5));
    }
}

