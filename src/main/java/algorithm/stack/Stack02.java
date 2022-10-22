package algorithm.stack;

import java.util.EmptyStackException;

public class Stack02 {
    private Integer[] arr;
    private int top = -1;

    public Stack02() {
        this.arr = new Integer[10000];
    }

    public Stack02(int size) {
        this.arr = new Integer[size];
    }

    public Integer[] getArr() {
        return arr;
    }

    public void push(int value) {
        // 10을 넣으면 arr[10] = 10
        this.arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비었습니다.");
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        boolean isEmpty = top == -1;
        return isEmpty;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }
}
