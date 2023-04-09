package ch.zhaw.iwi.devops.Ohce;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OhceTest {
    private String name = "Test";

    // Methode muss in ohce.java
    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    // Methode muss in ohce.java
    private boolean isPalindrome(String input) {
        return input.equals(reverse(input));
    }
    // Methode muss in ohce.java
    private String greet() {
        int hour = LocalDateTime.now().getHour();
        String greeting;
        if (hour >= 20 || hour < 6) {
            greeting = "¡Buenas noches " + name + "!";
        } else if (hour >= 6 && hour < 12) {
            greeting = "¡Buenos días " + name + "!";
        } else {
            greeting = "¡Buenas tardes " + name + "!";
        }
        return greeting;
    }

    @Test
    void reverseTest() {
        assertEquals("tset", reverse("test"));
        assertEquals("321", reverse("123"));
        assertEquals("sdrawkcab", reverse("backwards"));
        assertEquals("", reverse(""));
        assertEquals("a", reverse("a"));
    }

    @Test
    void reverseSpecialCharactersTest() {
        assertEquals(")(*&^%$#@!", reverse("!@#$%^&*()"));
    }

    @Test
    void reverseUnicodeCharactersTest() {
        assertEquals("ćiriličan i ćiriličar", reverse("račilirić i nacilirić"));
    }

    @Test
    void isPalindromeTest() {
        assertTrue(isPalindrome("otto"));
        assertTrue(isPalindrome("madam"));
        assertFalse(isPalindrome("hello"));
        assertFalse(isPalindrome("world"));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome(""));
    }

    @Test
    void isPalindromeSpecialCharactersTest() {
        assertTrue(isPalindrome("(*&^%$#@!)!@#$%^&*)"));
        assertFalse(isPalindrome("(*&^%$#@!)!@#$%^&)"));
    }

    @Test
    void isPalindromeUnicodeCharactersTest() {
        assertTrue(isPalindrome("аibоhiоbiа"));
        assertFalse(isPalindrome("ćiriličan i ćiriličar"));
    }
    @Test
    void greetTest() {
        String greeting = greet();
        int hour = LocalDateTime.now().getHour();
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
        String emptyName = "";
        name = emptyName;
        String greeting = greet();
        int hour = LocalDateTime.now().getHour();
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
        name = balkanName;
        String greeting = greet();
        int hour = LocalDateTime.now().getHour();
        if (hour >= 20 || hour < 6) {
            assertEquals("¡Buenas noches Иван!", greeting);
        } else if (hour >= 6 && hour < 12) {
            assertEquals("¡Buenos días Иван!", greeting);
        } else {
            assertEquals("¡Buenas tardes Иван!", greeting);
        }
    }
}
