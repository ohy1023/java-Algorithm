package likelion.stack;

public class Stack01 {

    private int[] arr = new int[10000]; // 기본 배열 선언
    private int pointer = 0;
    public Stack01() {
    }
    public Stack01(int size) {
        this.arr = new int[size];  // 생성자를 통해 사이즈 변경 가능
    }
    public int[] getArr() {
        return arr;
    }
    public void push(int value) {

        arr[pointer] = value;
        pointer++;
    }

    public int pop() {
        pointer--;
        int value = arr[pointer];
        return value;
    }
}
