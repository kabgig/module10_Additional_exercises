import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int findMaxQuantity() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/forest.txt"));
        Path path = Paths.get("src/forest.txt");
        int numLines = (int)Files.lines(path).count();

        int totalMushrooms = 0;
        int index = 0;
        int[] currentArray = Arrays
                .stream(scanner.nextLine().split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();
        numLines--;
        totalMushrooms += currentArray[0];

        int[] nextArray = Arrays
                .stream(scanner.nextLine().split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();
        numLines--;

        while (numLines >0 ) {

            if (index < currentArray.length - 1 && currentArray[index + 1] >= nextArray[index]) {
                totalMushrooms += currentArray[index + 1];
                index++;
            } else {
                totalMushrooms += nextArray[index];
                currentArray = nextArray;
                nextArray = Arrays
                        .stream(scanner.nextLine().split(";"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                numLines--;

            }
        }

        while (currentArray.length > index) totalMushrooms += currentArray[index++];
        return totalMushrooms;
    }
}
