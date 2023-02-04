import java.io.*;

public class Solution {
    public int getMul() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/data.txt"));

        int firstNumber = Integer.parseInt(br.readLine());
        String[] numStr = br.readLine().split(" ");
        int mul = 1;
        for (int i = 1; i <= firstNumber; i++) {
            for (int j = 0; j < numStr.length; j++) {
                if ((i % Integer.parseInt(numStr[j])) == 0) {
                    mul *= i;
                    break;
                }
            }
        }
        return mul;
    }
}
