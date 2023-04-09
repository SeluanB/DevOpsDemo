package ch.zhaw.iwi.devops.Ohce;
import java.time.LocalDateTime;

public class Ohce {
    private String name;

    public Ohce(String name) {
        this.name = name;
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        return input.equals(reverse(input));
    }

    public String greet() {
        int hour = getCurrentHour();
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

    public int getCurrentHour() {
        return LocalDateTime.now().getHour();
    }
}