package likelion.java1026;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashTable3Test {
    @Test
    @DisplayName("해쉬 추돌 문제 테스트")
    void insertAndSearchTest() {

        HashTable3 ht = new HashTable3();
        ht.insert("Yoonseo", 1);
        ht.insert("Seoyoon", 2);

        Assertions.assertEquals(1, ht.search("Yoonseo"));
        Assertions.assertEquals(2, ht.search("Seoyoon"));

    }

}