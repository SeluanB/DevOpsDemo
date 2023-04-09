package ch.zhaw.iwi.devops.Ohce;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OhceTest {
    private String name = "Test";
    private Ohce ohce = new Ohce(name);

    @Test
    void reverseTest() {
        assertEquals("tset", ohce.reverse("test"));
        assertEquals("321", ohce.reverse("123"));
        assertEquals("sdrawkcab", ohce.reverse("backwards"));
        assertEquals("", ohce.reverse(""));
        assertEquals("a", ohce.reverse("a"));
    }

    @Test
    void reverseSpecialCharactersTest() {
        assertEquals(")(*&^%$#@!", ohce.reverse("!@#$%^&*()"));
    }

    @Test
    void reverseUnicodeCharactersTest() {
        assertEquals("ćiriličan i ćiriličar", ohce.reverse("račilirić i načilirić"));
    }

    @Test
    void isPalindromeTest() {
        assertTrue(ohce.isPalindrome("otto"));
        assertTrue(ohce.isPalindrome("madam"));
        assertFalse(ohce.isPalindrome("hello"));
        assertFalse(ohce.isPalindrome("world"));
        assertTrue(ohce.isPalindrome("a"));
        assertTrue(ohce.isPalindrome(""));
    }

    @Test
    void isPalindromeSpecialCharactersTest() {
        assertTrue(ohce.isPalindrome("*&^%$#@!@#$%^&*"));
        assertFalse(ohce.isPalindrome("(*&^%$#@!)!@#$%^&)"));
    }

    @Test
    void isPalindromeUnicodeCharactersTest() {
        assertTrue(ohce.isPalindrome("аibоhihоbiа"));
        assertFalse(ohce.isPalindrome("ćiriličan i ćiriličar"));
    }

    @Test
void greetTest() {
    String greeting = ohce.greet();
    int hour = ohce.getCurrentHour();
    if (hour >= 20 || hour < 6) {
        assertEquals("¡Buenas noches " + name + "!", greeting);
    } else if (hour >= 6 && hour < 12) {
        assertEquals("¡Buenos días " + name + "!", greeting);
    } else {
        assertEquals("¡Buenas tardes " + name + "!", greeting);
    }
}

@Test
void greetEmptyNameTest() {
    Ohce emptyNameOhce = new Ohce("");
    String greeting = emptyNameOhce.greet();
    int hour = emptyNameOhce.getCurrentHour();
    if (hour >= 20 || hour < 6) {
        assertEquals("¡Buenas noches !", greeting);
    } else if (hour >= 6 && hour < 12) {
        assertEquals("¡Buenos días !", greeting);
    } else {
        assertEquals("¡Buenas tardes !", greeting);
    }
}

@Test
void greetUnicodeNameTest() {
    String balkanName = "Иван";
    Ohce unicodeNameOhce = new Ohce(balkanName);
    String greeting = unicodeNameOhce.greet();
    int hour = unicodeNameOhce.getCurrentHour();
    if (hour >= 20 || hour < 6) {
        assertEquals("¡Buenas noches Иван!", greeting);
    } else if (hour >= 6 && hour < 12) {
        assertEquals("¡Buenos días Иван!", greeting);
    } else {
        assertEquals("¡Buenas tardes Иван!", greeting);
    }
}
}


