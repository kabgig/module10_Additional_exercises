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

        int from0 = 0;
        int from1 = 0;
        int smallestTree = 0;

        if (trees.length % 2 != 0)
            for (int i = 2; i < trees.length; i += 2) {
                smallestTree = Math.min(trees[i - 2], trees[i]);
            }

        for (int i = 0; i < trees.length; i += 2) {
            from0 += trees[i];
        }
        from0 -= smallestTree;

        for (int i = 1; i < trees.length; i += 2) {
            from1 += trees[i];
        }

        System.out.println(Math.max(from0, from1));
    }
}
