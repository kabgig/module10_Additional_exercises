import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public double findSquare() throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new FileInputStream("src/points.txt"));
        String[] prevPoint = scanner.nextLine().split(" ");
        double square = 0;
        while (scanner.hasNextLine()) {
            String[] nextPoint = scanner.nextLine().split(" ");
            int prevX = Integer.parseInt(prevPoint[0]);
            int prevY = Integer.parseInt(prevPoint[1]);
            int nextX = Integer.parseInt(nextPoint[0]);
            int nextY = Integer.parseInt(nextPoint[1]);
            double a = prevY;
            double b = nextY;
            double h = nextX - prevX;
            square += (a + b) / 2 + h;
            prevPoint = nextPoint;
        }
        return square;
    }
}
