package algorithm.java1115;

import java.util.ArrayList;
import java.util.List;

public class QuickSortRecursion {

    List<Integer> merge(List<Integer> left, List<Integer> mid, List<Integer> right) {
        List<Integer> merge = new ArrayList<>();
        merge.addAll(left);
        merge.addAll(mid);
        merge.addAll(right);
        return merge;
    }

    List<Integer> quickSort(List<Integer> arr) {

        // 힌트) 리스트 3개에 담기
        List<Integer> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();

        // 1. 기준 값 뽑기
        int mid = arr.size() / 2;
        int pivot = arr.get(mid);

        // 2.기준값 기준으로 작으면 왼쪽, 크면 오른쪽에 담기
        for (int i = 0; i < arr.size(); i++) {
            if (pivot > arr.get(i)) {
                smallList.add(arr.get(i));
            } else if (pivot < arr.get(i)) {
                bigList.add(arr.get(i));
            } else {
                midList.add(arr.get(i));
            }
        }

        return merge(quickSort(smallList), quickSort(midList), quickSort(bigList));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 18, 5, 19, 5, 25, 40, 50};
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        QuickSortRecursion qsr = new QuickSortRecursion();
        System.out.println(qsr.quickSort(al));


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




    }
}
