package algorithm.java1109;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class SelectSortFunction {
    int[] solution(int[] arr, BiFunction<Integer,Integer,Boolean> biFunction) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (biFunction.apply(arr[idx], arr[j])) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }

        return arr;
    }

    int[] solution(int[] arr, BiPredicate<Integer,Integer> bp) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (bp.test(arr[idx], arr[j])) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int idx) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectSortFunction ss = new SelectSortFunction();
        
        //Funtion 사용
        Function<Integer[], Boolean> fn = (arr1) -> arr1[0] > arr1[1];
        System.out.println(fn.apply(new Integer[]{10, 20}));

        //BiPredicate 사용
        BiPredicate<Integer, Integer> bp = (a, b) -> a < b;
        System.out.println(Arrays.toString(ss.solution(arr, bp)));


        // Bifunction 사용
        BiFunction<Integer, Integer, Boolean> biFunction = (a, b) -> a < b;
        System.out.println(Arrays.toString(ss.solution(arr, biFunction)));

    }
}
