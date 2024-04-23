import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {

    private static MorseCodeTree _morseCodeTree_ = new MorseCodeTree(); // MorseCodeTree instance

    public static String convertToEnglish(String morseCode) {
        String englishStr = "";
        String[] words = morseCode.split("/"); // Split the Morse code string into words

        for (String word : words) {
            String[] letters = word.trim().split(" "); // Split each word into letters

            for (String letter : letters) {
                String englishLetter = _morseCodeTree_.fetch(letter); // Fetch the English letter from the tree
                englishStr += englishLetter; // Append the English letter to the result string
            }

            englishStr += " "; // Add a space after each word
        }

        return englishStr.toString().trim(); // Trim any leading/trailing spaces and return the result
    }

    public static String convertToEnglish(File file) throws FileNotFoundException {
        String morseCode = "";
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            morseCode += scan.next() + " "; // Read Morse code from the file
        }

        scan.close();
        return convertToEnglish(morseCode.toString()); // Convert the Morse code to English
    }

    public static String printTree() {
        return String.join(" ", _morseCodeTree_.toArrayList()); // Print the Morse code tree as a string
    }
}