import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public boolean arePalindromes() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("Root/src/strings.txt"));

        String phrase = "";
        boolean result = true;
        List<Character> palindrome = new ArrayList<>();

        while (scanner.hasNextLine()) {
            phrase = scanner.nextLine().toLowerCase().replace(" ", "");
            for (int i = phrase.length()-1; i >= 0; i--) {
                palindrome.add(phrase.charAt(i));
            }
            int index = 0;
            for (Character items : palindrome)
                if (!items.equals(phrase.charAt(index++))) {
                    result = false;
                    break;
                }
            if (!result) break;
            palindrome.clear();
        }
        return result;
    }
}
