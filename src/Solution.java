import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public void findMerchant(String name) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/outcome.txt"));
        String firstLine = scanner.nextLine();

        List<String[]> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] firstArray = scanner.nextLine().split(";");
            if (firstArray[1].equals(name)) {
                String[] product = {firstArray[2], firstArray[3], firstArray[4]};
                data.add(product);
                break;
            }
        }

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(";");
            for (String[] item : data) {
                if (line[1].equals(name)) {
                    if (item == null || !(item[0].equals(line[2]))) {
                        String[] product2 = {line[2], line[3], line[4]};
                        data.add(product2);
                        break;
                    } else {
                        // item[1] = String.valueOf(Integer.parseInt(line[3]) + Integer.parseInt(item[1]));
                        // item[2] = String.valueOf(Integer.parseInt(line[4]) /*+ Integer.parseInt(item[2])*/);
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

        List<String[]> countedProducts = new ArrayList<>();
        for (int i = 0; i < productNames.size(); i++) {
            String[] array = {productNames.get(i), "0", "0"};
            countedProducts.add(array);
        }

        int count = 0;
        for (String productName : productNames) {
            for (String[] listing : data) {
                if (productName.equals(listing[0])) {
                    if (countedProducts.get(count) == null)
                        countedProducts.add(listing);
                    else {
                        int amount = Integer.parseInt(countedProducts.get(count)[1])
                                + Integer.parseInt(listing[1]);
                        int price = /*Integer.parseInt(countedProducts.get(count)[2])
                                + */Integer.parseInt(listing[2]);
                        String[] temporary = {
                                productName,
                                String.valueOf(amount),
                                String.valueOf(price),
                                String.valueOf(price * amount)
                        };
                        countedProducts.set(count, temporary);
                    }
                }
            }
            count++;
        }
        //COUNTING TAX
        double tax = 0.0;
        for (String[] item : countedProducts) {
            tax += Double.parseDouble(item[3]);
        }
        tax = tax / 100 * 15;
        //PRINTING RESULT
        for (String[] item : countedProducts)
            System.out.println(item[0] + "," + item[1] + "," + item[2] + "," +
                    item[3]);
        System.out.println("tax: " + String.format("%.1f", tax));
    }
}
