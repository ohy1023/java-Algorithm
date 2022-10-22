package algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @BeforeEach 각 테스트가 실행되기 전에 실행되는 구간
 * <p>
 * # 각 테스트는 독립적으로 실행되어야 한다.
 * <p>
 * # 테스트코드에서 할 수 있는 것들
 * 1. 테스트하는 코드를 만들어서 다음에도 실행할 수 있게
 * 2. 기능 설계
 * <p>
 * # 테스트 만들때 원칙
 * negative Test부터 - 안될것 같은 것부터 테스트를 만든다
 * 되는 것 부터 만들지 않고 안되는 것 부터 테스트를 만든다.
 */

class Stack02Test {


    @BeforeEach
    void setUp() {
        System.out.println("beforeEach는 잘 생각하고 사용 할 것");

    }

    @Test
    @DisplayName("push 작동 테스트")
    void pushTest() {
        Stack02 st = new Stack02();

        st.push(10);
        st.push(20);

        Integer[] arr = st.getArr();

        assertEquals(10, arr[0]);
        assertEquals(20, arr[1]);

    }

    @Test
    @DisplayName("pop 작동 테스트")
    void popTest() {

        Stack02 st = new Stack02();

        st.push(10);
        st.push(20);

        assertEquals(20, st.pop());
        assertEquals(10, st.pop());
    }

    @Test
    @DisplayName("isEmpty 작동 테스트")
    void isEmpty() {
        Stack02 st = new Stack02();

        assertTrue(st.isEmpty());

        st.push(10);
        assertFalse(st.isEmpty());

        st.pop();
        assertTrue(st.isEmpty());
    }

    @Test
    @DisplayName("스택이 비었는데 pop하는 경우")
    void realStack() {
        Stack02 st = new Stack02();

        // Exception 예외 검증
        assertThrows(RuntimeException.class, () -> st.pop());
    }

    @Test
    @DisplayName("스택이 비었는데 peak하는 경우")
    void realStack2() {
        Stack02 st = new Stack02();

        // Exception 예외 검증
        assertThrows(EmptyStackException.class, () -> st.peek());
    }

    @Test
    @DisplayName("peek 구현 테스트")
    void peek() {
        Stack02 st = new Stack02();
        st.push(10);
        int peeked = st.peek();
        assertEquals(10,peeked);
    }
}