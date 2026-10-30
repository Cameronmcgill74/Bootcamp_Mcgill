package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//You should have two methods here, one to return a list of
//products, another to take a product and write it to the file
//No menus, no scanner, no questions, just read from the file
//write to the file. That's it.
public class FileManager {
    //The reason these are static is so that you can directly
    //call the method like FileManager.getProducts()
    //Notice the capital F
    public static List<Product> getProducts(){
        //You are going to write code to read the products
        //from the file, put them in a list and return them
        List<Product> inventory = new ArrayList<>();
       try{
           FileReader fileReader = new FileReader("C:\\Bootcamp\\Fall2026JavaBootcamp\\Week3\\4.Thursday\\OnlineStoreTemplate\\src\\main\\java\\resources\\products.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           String row;
           bufferedReader.readLine();
           while ((row = bufferedReader.readLine()) != null) {
               String[] brokenUpRow = row.split("\\|");
               String sku = brokenUpRow[0];
               String productName = brokenUpRow[1];
               double price = Double.parseDouble(brokenUpRow[2]);
               String department = brokenUpRow[3];

               Product product = new Product(sku, productName, price, department);

               inventory.add(product);
           }
       } catch (IOException ex){
           System.out.println("Could not read the file. Check the file try again.");
       }catch (Exception ex){
           System.out.println("could not read data from the file. Check the file try again.");
       }

        return inventory;
    }

    public static void writeProduct(Product product){
        //This method you will take the product that is being
        //put in to this method, take its data and write it to the file
    try {
        FileWriter fileWriter = new FileWriter("C:/Bootcamp/Fall2026JavaBootcamp/Week3/4.Thursday/OnlineStoreTemplate/src/main/java/resources/products.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line = String.format("%d|%s|%.2f|%.2f", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());

        bufferedWriter.write(line);
        bufferedWriter.newLine();

        System.out.println("Write complete!");
    }catch (IOException ex){
        System.out.println("Could not write to the files.");
    }catch (Exception ex){
        System.out.println("Error when handling the data. ");
    }

    }
}
