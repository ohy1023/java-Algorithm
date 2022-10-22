package algorithm.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 테스트 - 스택 실행
 */

class Stack01Test {

    @Test
    @DisplayName("push 작동 테스트")
    void pushTest() {
        Stack01 st = new Stack01();

        st.push(10);
        st.push(20);

        int[] arr = st.getArr();

        assertEquals(10, arr[0]);
        assertEquals(20, arr[1]);

    }

    @Test
    @DisplayName("pop 작동 테스트")
    void popTest() {
        Stack01 st = new Stack01();

        st.push(10);
        st.push(20);

        assertEquals(20, st.pop());
        assertEquals(10, st.pop());


    }

}