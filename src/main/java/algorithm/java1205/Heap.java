package algorithm.java1205;

import java.util.Arrays;

public class Heap {

    private int[] makeHeap(int[] arr, int parentIdx) {
        int leftIdx = parentIdx * 2 + 1;
        int rightIdx = parentIdx * 2 + 2;
        int greaterIdx = parentIdx;

        if (leftIdx < arr.length && arr[leftIdx] > arr[greaterIdx]) {
            greaterIdx = leftIdx;
        }
        if (rightIdx < arr.length && arr[rightIdx] > arr[greaterIdx]) {
            greaterIdx = rightIdx;
        }

        int temp = arr[parentIdx];
        arr[parentIdx] = arr[greaterIdx];
        arr[greaterIdx] = temp;

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {6, 5, 7, 8};
        Heap heap = new Heap();
        int[] heapArr = heap.makeHeap(arr, 1);
        System.out.println(Arrays.toString(heapArr));

        int[] heapArr2 = heap.makeHeap(arr, 0);
        System.out.println(Arrays.toString(heapArr2));
    }
}
