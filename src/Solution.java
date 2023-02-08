import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public void solution() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/trees.txt"));
        int result = 0;
        int[] trees = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (trees.length == 1) {
            System.out.println(trees[0]);
            return;
        }
        if (trees.length < 4) {
            for (int i = 1; i < trees.length; i++) {
                result = Math.max(trees[i - 1], trees[i]);
            }
            System.out.println(result);
            return;
        }

    }
}
