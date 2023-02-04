import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public int getCountWords() throws IOException {
        FileReader reader = new FileReader("src/text.txt");
        BufferedReader bf = new BufferedReader(reader);
        int c = 0;
        int count = 0;
        while (c != -1){
            c = bf.read();
            if ((char)c == ' ') count++;
        }
    }
}