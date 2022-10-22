package algorithm.bracket;

import java.util.Stack;

public class BracketSolveByStack {
    public boolean solution(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i)) {
                st.push(str.charAt(i));
            } else if (')' == str.charAt(i)) {
                if (st.empty()) {
                    return false;
                }
                st.pop();
            }
        }

        return st.empty();
    }
}
