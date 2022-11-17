package algorithm.java1117;


import java.util.Arrays;

/**
 * 1. pivot을 정한다
 * 2. pivot보다 arr[leftIdx]가 작으면 leftIdx +=1
 * 3. pivot보다 arr[rightIdx]가 크면 rightIdx -=1
 * 4. leftIdx <= rightIdx 면 교환
 * 5. 교환 했으면 leftIdx+=1, rightIdx -= 1
 * 6. leftIdx <= rightIdx 보다 작을떄 까지 반복
 * 7. 그룹을 나누어 재귀 설정
 * 8. 재귀 탈출 조건 설정
 */

public class QuickSortByArray2 {

    int[] solution(int[] arr, int startIdx, int endIdx) {


        int lt = startIdx;
        int rt = endIdx;

        int pivot = arr[(lt + rt) / 2];

        while (lt <= rt) {

            while (arr[lt] < pivot) {
                lt++;
            }
            while (arr[rt] > pivot) {
                rt--;
            }

            // 교환 후 lt +1, rt -1
            if (lt <= rt) {

                swap(arr, lt, rt);
                lt++;
                rt--;

            }

        }

        // 그룹 나누기 + 재귀 탈출 조건 설정
        if (startIdx < rt) {
            solution(arr, startIdx, rt);
        }
        if (endIdx > lt) {
            solution(arr, lt, endIdx);
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
        System.out.println(Arrays.toString(qsba.solution(arr, 0, arr.length - 1)));
    }
}
