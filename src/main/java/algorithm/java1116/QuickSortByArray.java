package algorithm.java1116;


import java.util.Arrays;

/**
 * 1. pivot을 정한다
 * 2. pivot보다 arr[leftIdx]가 작으면 leftIdx +=1
 * 3. pivot보다 arr[rightIdx]가 크면 rightIdx -=1
 * 4. leftIdx <= rightIdx 면 교환
 * 5. 교환 했으면 leftIdx+=1, rightIdx -= 1
 */

public class QuickSortByArray {
    int[] solution(int[] arr) {
        int lt = 0;
        int rt = arr.length - 1;

        int pivot = arr[arr.length/2];
        System.out.println(pivot);
        while (arr[lt] < pivot) {
            lt++;
        }
        while (arr[rt] > pivot) {
            rt--;
        }

        int temp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = temp;

        lt += 1;
        rt -= 1;


        return arr;
    }


    public static void main(String[] args) {
        QuickSortByArray qsba = new QuickSortByArray();
        int[] arr = new int[]{20, 18, 5, 19, 40, 50, 5, 25};
        System.out.println(Arrays.toString(qsba.solution(arr)));
    }
}
