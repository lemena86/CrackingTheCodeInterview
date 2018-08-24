package Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question1_1Test {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};

    @Test
    void isUnique() {
        String word = "abcde";
        boolean wordA = Question1_1.isUnique(word);
        boolean wordB = Question1_1.isUnique1(word);
        boolean wordC = Question1_1.isUnique2(word);
        boolean wordD = Question1_1.isUnique3(word);
        boolean wordE = Question1_1.isUnique4(word);
        assertTrue(wordA);
        assertTrue(wordA == wordB && wordB == wordC && wordC == wordD && wordD == wordE);

        word = "hello";
        wordA = Question1_1.isUnique(word);
        wordB = Question1_1.isUnique1(word);
        wordC = Question1_1.isUnique2(word);
        wordD = Question1_1.isUnique3(word);
        wordE = Question1_1.isUnique4(word);
        assertFalse(wordA);
        assertTrue(wordA == wordB && wordB == wordC && wordC == wordD && wordD == wordE);

    }
}