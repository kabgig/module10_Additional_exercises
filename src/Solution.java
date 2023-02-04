import java.io.*;
import java.util.Scanner;

public class Solution {
    public void writeOrder() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/numbers.txt"));
        Writer writer = new FileWriter("src/output.txt");
        int count = 1;
        boolean haveNums = false;
        int digit;
        String numLine = "";
        while (scanner.hasNextLine()) {
            digit = Integer.parseInt(scanner.nextLine());
            if (digit == count) {
                numLine += digit + " ";
                haveNums = true;
            }
            count++;
        }
        if (!haveNums) writer.write("0");
        else writer.write(numLine.trim());
        writer.close();
    }
}