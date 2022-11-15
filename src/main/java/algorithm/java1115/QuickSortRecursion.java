package algorithm.java1115;

import java.util.ArrayList;
import java.util.List;

public class QuickSortRecursion {
    int[] quickSort(int[] arr) {

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 18, 5, 19, 5, 25, 40, 50};

        // 힌트) 리스트 3개에 담기
        List<Integer> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();

        // 1. 기준 값 뽑기
        int mid = arr.length / 2;
        int pivot = arr[mid];

        midList.add(pivot);

        // 2.기준값 기준으로 작으면 왼쪽, 크면 오른쪽에 담기
        for (int i = 0; i < arr.length; i++) {
            if (pivot > arr[i]) {
                smallList.add(arr[i]);
            } else if (pivot < arr[i]) {
                bigList.add(arr[i]);
            }
        }


//        int lt = mid - 1;
//        int rt = mid + 1;
//        while (lt != -1) {
//            if (arr[lt] <= pivot) {
//                smallList.add(arr[lt]);
//            } else {
//                bigList.add(arr[lt]);
//            }
//            lt--;
//        }

        System.out.println(smallList);
        System.out.println(bigList);
        // 3,


    }
}
