package algorithm.java1117;


import java.util.Arrays;

/**
 * 1. pivot을 정한다
 * 2. pivot보다 arr[leftIdx]가 작으면 leftIdx +=1
 * 3. pivot보다 arr[rightIdx]가 크면 rightIdx -=1
 * 4. leftIdx <= rightIdx 면 교환
 * 5. 교환 했으면 leftIdx+=1, rightIdx -= 1
 */

public class QuickSortByArray2 {

    int[] solution(int[] arr) {

        int lt = 0;
        int rt = arr.length - 1;

        int pivot = arr[arr.length / 2];

        // -------여기 아랫줄이 반복됨 ---------
        while (lt <= rt) {

            while (arr[lt] < pivot) {
                lt++;
            }
            while (arr[rt] > pivot) {
                rt--;
            }

            // 교환 후 lt +1, rt -1
            swap(arr, lt, rt);

            lt++;
            rt--;

            System.out.printf("현재 leftidx 위치 %d \n",lt);
            System.out.printf("현재 rightidx 위치 %d \n",rt);
            System.out.println("----------------------");
        }

        return arr;
    }

    private static void swap(int[] arr, int lt, int rt) {
        int temp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = temp;
    }


    public static void main(String[] args) {
        QuickSortByArray2 qsba = new QuickSortByArray2();
        int[] arr = new int[]{20, 18, 5, 19, 40, 50, 5, 25};
        System.out.println(Arrays.toString(qsba.solution(arr)));
    }
}
