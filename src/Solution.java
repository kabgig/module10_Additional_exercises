import java.io.*;
import java.util.*;

public class Solution {
    public void getOutput() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/files.txt"));
        Writer writer = new FileWriter("src/output.txt");
        List<String[]> bmpGr = new ArrayList<>();
        List<String[]> txtGr = new ArrayList<>();
        List<String[]> zipGr = new ArrayList<>();

        //sorting files to groups
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            String[] extCheck = line[0].split("[.]");
            if (extCheck[1].equals("bmp")) bmpGr.add(line);
            if (extCheck[1].equals("txt")) txtGr.add(line);
            if (extCheck[1].equals("zip")) zipGr.add(line);
        }
        //sorting names in groups
        Collections.sort(bmpGr, Comparator.comparing((String[] a) -> a[0]));
        Collections.sort(txtGr, Comparator.comparing((String[] a) -> a[0]));
        Collections.sort(zipGr, Comparator.comparing((String[] a) -> a[0]));

        if (!(bmpGr.isEmpty())) {
            for (String[] line : bmpGr) writer.write(line[0] + "\n");
            writer.write("----------\n");
            writer.write("Summary: " + countSize(bmpGr) + "\n");
            writer.write("\n");
        }
        if (!(txtGr.isEmpty())) {
            for (String[] line : txtGr) writer.write(line[0] + "\n");
            writer.write("----------\n");
            writer.write("Summary: " + countSize(txtGr) + "\n");
            writer.write("\n");
        }
        if (!(zipGr.isEmpty())) {
            for (String[] line : zipGr) writer.write(line[0] + "\n");
            writer.write("----------\n");
            writer.write("Summary: " + countSize(zipGr));
        }

        writer.close();
    }

    public static String countSize(List<String[]> list) {
        String size;
        double sizeLong = 0;
        //counting size
        for (String[] line : list) {
            if (line[2].equals("B")) sizeLong += Long.parseLong(line[1]);
            if (line[2].equals("KB")) sizeLong += (Long.parseLong(line[1]) * 1000);
            if (line[2].equals("MB")) sizeLong += (Long.parseLong(line[1]) * 1000_000);
        }
        if (sizeLong < 1000) size = sizeLong + " B";
        if (sizeLong > 1000_000) {
            sizeLong /= 1000_000; //ROUND THE RIGHT WAY!
            size = Math.round(sizeLong) + " MB";
        } else {
            sizeLong /= 1000;
            size = Math.round(sizeLong) + " KB";
        }
        return size;
    }
}
