package algorithm.java1028;


import java.util.HashSet;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for (var s : phone_book) {
            set.add(s);
        }

        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PhoneNumberList numberList = new PhoneNumberList();
        System.out.println(numberList.solution(new String[]{"12","123"}));
    }
}
