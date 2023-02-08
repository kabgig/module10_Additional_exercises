import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public void solution() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/trees.txt"));

        int[] trees = Arrays.stream(Arrays.stream(scanner
                .nextLine()
                .split(" ")
                .mapToInt(Integer::parseInt)
                .toArray());
    }
}
