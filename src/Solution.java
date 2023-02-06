import java.io.*;
import java.util.Scanner;

public class Solution {
    public void solve() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/arithmetic.txt"));
        Writer writer = new FileWriter("src/answers.txt");
        String result = "";
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            int digit1 = Integer.parseInt(data[0]);
            String opSym = data[1];
            int digit2 = Integer.parseInt(data[2]);
            int res = 0;
            if (opSym.equals("+")) res = digit1 + digit2;
            if (opSym.equals("-")) res = digit1 - digit2;
            if (opSym.equals("*")) res = digit1 * digit2;
            if (opSym.equals("/")) res = digit1 / digit2;
            result += digit1 + " " + data[1] + " " + digit2 + " = " + res + "\n";
        }
        writer.write(result.trim());
        writer.close();
    }
}