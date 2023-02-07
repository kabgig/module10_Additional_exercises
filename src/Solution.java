import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public String translate() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/message.txt"));
        String result = "";
        while (scanner.hasNextLine()) {
            String phrase = scanner.nextLine();
            for (int i = 0; i < phrase.length(); i++) {
                char c = phrase.charAt(i);
                if (Character.isLetter(c)) {
                    int chr = c;
                    String biStr = Integer.toBinaryString(chr);
                    result += biStr;
                } else {
                    result += String.valueOf(c);
                }
            }
            result += "\n";
        }
        return result.trim();
    }
}
