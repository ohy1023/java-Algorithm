package algorithm.bracket;


// 효율성에 문제 있음 ( 시간 초과 )
public class SolveBracket {
    public boolean solution(String str) {
        while (str.indexOf("()") >= 0) {
            str = str.replace("()", "");
        }
        return str.length() == 0;
    }
}
