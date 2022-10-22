package algorithm.bracket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolveBracketTest {

    @Test
    @DisplayName("괄호가 잘 풀리는 지")
    void bracket() {

        SolveBracket solveBracket = new SolveBracket();
        assertTrue(solveBracket.solution("()()"));
        assertTrue(solveBracket.solution("(())()"));
        assertFalse(solveBracket.solution(")()("));
        assertFalse(solveBracket.solution("((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))"));

    }
}