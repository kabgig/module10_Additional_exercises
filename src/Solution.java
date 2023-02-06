import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public void findMerchant(String name) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/outcome.txt"));
        String firstLine = scanner.nextLine();

        String[] firstArray = scanner.nextLine().split(";");
        List<String[]> data = new ArrayList<>();
        String[] product = {firstArray[2], firstArray[3], firstArray[4]};
        data.add(product);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(";");
            for (String[] item : data) {
                if (line[1].equals(name)) {
                    if (item == null || !(item[0].equals(line[2]))) {
                        String[] product2 = {line[2], line[3], line[4]};
                        data.add(product2);
                        break;
                    } else {
                        item[1] = String.valueOf(Integer.parseInt(line[3]) + Integer.parseInt(item[1]));
                        item[2] = String.valueOf(Integer.parseInt(line[4]) + Integer.parseInt(item[2]));
                    }
                }
            }
        }
        //GATHERING ALL PRODUCT NAMES
        List<String> productNames = new ArrayList<>();
        productNames.add(data.get(0)[0]);
        for (String[] item : data) {
        boolean have = false;
            for (String productName : productNames)
                if (item[0].equals(productName)) have = true;
            if (!have) {
                productNames.add(item[0]);
            }
        }
        //ТЕПЕРЬ НУЖНО ПОСЧИТАТЬ ПРОДАЖИ НА КАЖДЫЙ ПРОДУКТ-----------
        List<String[]> countedProducts = new ArrayList<>();
        for (String name : productNames){

        }

        //PRINTING RESULT
        for (var item : data)
            System.out.println(item[0] + "," + item[1] + "," + item[2] + "," +
                    (Integer.parseInt(item[1]) * Integer.parseInt(item[2]))
            );

        for(var i: productNames) System.out.println(i);
    }
}
