import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public void dance() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/dance.txt"));
        Writer writer = new FileWriter("src/rhythm.txt");
        int rhythm = Integer.parseInt(scanner.nextLine());
        List<Integer> dances = new ArrayList<>();

        while (scanner.hasNextLine()){
            dances.add(Integer.parseInt(scanner.nextLine()));
        }
        String result =  "";
        for (int d : dances){
            int cyclesNumber = d/rhythm;
            int restSteps = d%rhythm;
            result += cyclesNumber + " " + restSteps + "\n";
        }
        writer.write(result.trim());
        writer.close();
    }
}
