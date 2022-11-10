package algorithm.java1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ArraysNum {
    int[] solutionByList(int[] arr) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (integerList.get(integerList.size() - 1) != arr[i]) {
                integerList.add(arr[i]);
            }
        }


        int[] answer = new int[integerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = integerList.get(i);
        }
        return answer;
    }

    int[] solutionByStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        ArraysNum an = new ArraysNum();
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(an.solutionByList(arr)));
        System.out.println(Arrays.toString(an.solutionByStack(arr)));
    }
}
