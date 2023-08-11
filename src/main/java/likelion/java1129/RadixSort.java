package likelion.java1129;


/**
 * 배열 10개를 만들고
 * 7,4,5,9,1,0 를 배열의 인덱스에 맞게 넣고
 * 앞에서부터 꺼내서 정렬
 */

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 5, 9, 1, 0};
        Integer[] sortArr = new Integer[10];

        for (int a : arr) {
            sortArr[a] = a;
        }
        for (Integer integer : sortArr) {
            if (integer != null) {
                System.out.print(integer + " ");
            }
        }
    }
}

