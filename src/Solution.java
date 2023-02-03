import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.NumberFormat;

public class Solution {
    public String getReceipt() throws IOException {
        BufferedReader reader
                = new BufferedReader(
                        new FileReader("Root/src/receipt.txt"));
        String line;
        double sum = 0.0;

        while ((line = reader.readLine()) != null) {
            String[] res = line.split(";");
            sum += Double.valueOf(res[2]) * Double.valueOf(res[1]);
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

      //  return String.valueOf(formatter.format(sum));
        return String.format("%.2f", sum);
    }
}