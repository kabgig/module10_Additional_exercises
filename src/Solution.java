import java.io.*;
public class Solution {
    public String getReceipt() throws IOException {
        BufferedReader reader
                = new BufferedReader(
                        new FileReader("src/receipt.txt"));
        String line;
        double sum = 0.0;

        while ((line = reader.readLine()) != null) {
            String[] res = line.split(";");
            sum += Double.valueOf(res[2]) * Double.valueOf(res[1]);
        }
        return String.valueOf(sum);
    }
}