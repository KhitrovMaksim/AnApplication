package ua.com.foxminded.anapplication;

public class Runner {

    public static void main(String[] args) {
        CharacterCount characterCount = new CharacterCount();
        CachedResults cache = new CachedResults();
        String input = "";

        if (!cache.getResult(input).equals("")) {
            System.out.println("From cashe:\n" + input + "\n" + cache.getResult(input));
        } else {
            cache.putResult(input, characterCount.countOfChars(input));
            System.out.println(input + "\n" + characterCount.countOfChars(input));
        }
    }

}
