package likelion.bracket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketSolveByStackTest {
    @Test
    @DisplayName("괄호가 잘 풀리는 지")
    void bracket() {

        BracketSolveByStack sb = new BracketSolveByStack();
        assertTrue(sb.solution("()()"));
        assertTrue(sb.solution("(())()"));
        assertFalse(sb.solution(")()("));
        assertFalse(sb.solution("((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))"));

    }

}