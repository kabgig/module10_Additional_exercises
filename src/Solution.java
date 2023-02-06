import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public void solution(String district, int fromYear, int toYear) throws IOException {
        FileWriter fr = new FileWriter("src/data.txt");
        Scanner sc = new Scanner(new FileInputStream("src/crop-volumes.txt"));
        int firstYearIndex = 0, secondYearIndex = 0;
        String[]data = sc.nextLine().split(";");
        for (int i = 2; i < data.length; i++) {
            if (data[i].equals(String.valueOf(fromYear))) firstYearIndex = i;
            if (data[i].equals(String.valueOf(toYear))) secondYearIndex = i;
        }
        String result = "Part;"+ fromYear + ";" + toYear + "\n";
        while (sc.hasNextLine()){
            String[] data2 = sc.nextLine().split(";");
            double percCng = Double.parseDouble(data2[secondYearIndex]) -
                    Double.parseDouble(data2[firstYearIndex]);
            if (percCng > 4 && data2[1].equals(district)) result +=
                    data2[0] + ";" +
                    Double.parseDouble(data2[firstYearIndex]) + ";" +
                            Double.parseDouble(data2[secondYearIndex]) + "\n";
        }
        fr.write(result.trim());
        fr.close();
    }
}
