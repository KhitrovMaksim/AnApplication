package ua.com.foxminded.charscounter;

public class Runner {

    public static void main(String[] args) {
        CharacterCount characterCount = new CharacterCount();
        String input = "hello!";

        System.out.println(characterCount.countOfChars(input));

    }

}
