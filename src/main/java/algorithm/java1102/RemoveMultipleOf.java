package algorithm.java1102;

import java.util.ArrayList;
import java.util.List;

public class RemoveMultipleOf {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        int cnt = 50;
        for (int i = 2; i < cnt; i++) {
            arrayList.add(i);
        }
        for (int j = 0; j < arrayList.size(); j++) {
            if (arrayList.get(j) % 2 == 0 && arrayList.get(j) > 2) {
                arrayList.remove(j);
            }
        }


//        arrayList.removeIf(num -> num % 2 == 0 && num != 2);

        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
