import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public void solution(double n) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/EGE.txt"));
        String line = scanner.nextLine();
        String result = "";
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(";");
            if (Double.parseDouble(data[2]) >= n){
                result += data[0] + "\n";
            }
        }
        System.out.println(result.trim());
    }
}
