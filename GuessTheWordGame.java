import java.util.Scanner;

public class GuessTheWordGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of words for the player to guess  
        String[] words = {"apple", "banana", "orange", "laptop", "mobile", "python", "java"};
        
        // Select a random word  
        String secretWord = words[(int) (Math.random() * words.length)];

        // Prepare the hidden word (e.g., "_____")
        char[] guessed = new char[secretWord.length()];
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = '_';
        }

        int attempts = 6;  // total chances
        boolean wordGuessed = false;

        System.out.println("Welcome to Guess The Word Game!");
        System.out.println("You must guess the letters of the hidden word.");
        System.out.println("Word: " + String.valueOf(guessed));

        while (attempts > 0 && !wordGuessed) {
            System.out.print("\nEnter a letter: ");
            char letter = sc.next().toLowerCase().charAt(0);

            boolean found = false;

            // Check if letter exists in the secret word
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter && guessed[i] == '_') {
                    guessed[i] = letter;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Good job! Letter found.");
            } else {
                attempts--;
                System.out.println("Wrong letter! Attempts left: " + attempts);
            }

            System.out.println("Current Word: " + String.valueOf(guessed));

            // Check if word is fully guessed
            if (String.valueOf(guessed).equals(secretWord)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("\n🎉 Congratulations! You guessed the word: " + secretWord);
        } else {
            System.out.println("\n❌ Out of attempts! The word was: " + secretWord);
        }
        
        sc.close();
    }
}