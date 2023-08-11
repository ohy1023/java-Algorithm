package likelion.java1024;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthNumTest {

    @Test
    @DisplayName("배열 사용")
    void arrayTest() {
        KthNum kthNum = new KthNum();
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] solution = kthNum.solutionByArray(arr, commands);
        assertArrayEquals(solution,new int[]{5,6,3});

    }

    @Test
    @DisplayName("우선 순위 큐 사용")
    void copyOfRangeTest() {
        KthNum kthNum = new KthNum();
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] solution = kthNum.solutionByPriorityQueue(arr, commands);
        assertArrayEquals(solution,new int[]{5,6,3});

    }
}