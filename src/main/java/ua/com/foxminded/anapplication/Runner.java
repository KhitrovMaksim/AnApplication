package ua.com.foxminded.anapplication;

public class Runner {

    public static void main(String[] args) {
        CharacterCount characterCount = new CharacterCount();
        String input = "hello!";

        System.out.println(input + "\n" + characterCount.countOfChars(input));

    }

}
