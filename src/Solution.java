import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public void solution() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/data2.txt"));
        Writer writer = new FileWriter("src/output.txt");

        int midStr;
        int dfr = scanner.nextInt();
        int allChars = 0;

        //putting all strings to list
        List<String> phrases = new ArrayList<>();
        while (scanner.hasNextLine()){
            phrases.add(scanner.nextLine());
        }
        phrases.remove(0);
        //count midStr
        for (String s : phrases)
            allChars += s.length();
        midStr = allChars/ phrases.size();// midStr +-difference

        writer.write(midStr + "\n");


        String result = "";
        for(String s:phrases) {
            int sL = s.length();
            if ((midStr - dfr) <= sL && sL <= (midStr + dfr)) result += s + "\n";
        }
        writer.write(result.trim());
        writer.close();
    }
}
