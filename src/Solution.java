import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public int getCountWords() throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(new FileInputStream ("Root/src/text.txt"));
        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(" ");
            count += words.length;
        }
        return count;
    }
}