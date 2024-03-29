package likelion.java1102;

import java.util.ArrayList;
import java.util.List;

public class RemoveMultipleOf {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        int cnt = 50;
        for (int i = 2; i <= cnt; i++) {
            arrayList.add(i);
        }
        for (int i = 2; i * i <= cnt ; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (isNotContain(arrayList, i)) {
                    break;
                }
                if (arrayList.get(j) % i == 0 && arrayList.get(j) != i) {
                    arrayList.remove(j);
                }
            }
        }

        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }

    private static boolean isNotContain(List<Integer> arrayList, int i) {
        return !(arrayList.contains(i));
    }
}
