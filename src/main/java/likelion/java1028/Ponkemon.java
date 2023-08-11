package likelion.java1028;

import java.util.HashSet;

public class Ponkemon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length / 2;
        if (set.size() < n) {
            return set.size();
        } else {
            return n;
        }
    }

}
