package org.example;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
//Want to ask questions? Ask them here
//Want to use the scanner? Use it here
//User input? Also here. You will have to call the file manager
//and the product class from here.
public class Main {
    public static void main(String[] args) {
        List<Product> products = FileManager.getProducts();
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        //1. Use the File Manager to load the file and create a list of products
        //2. Instantiate a shopping cart
        //3. Show the menu to the user
        //4. Based on what they select, use the right method
        //5. Use the shopping cart object you made to add and remove things from the shopping cart
        //6. The key thing is "How am I going to grab the specific item the user wants?"
    while (true){
        System.out.println("====Online Store====");
        System.out.println("1. Display Products");
        System.out.println("2. Display Cart");
        System.out.println("3. Exit");
        System.out.println("====================");
        System.out.print("Choose an option");
         int userInput = scanner.nextInt();

         switch (userInput){
             case 1:
                 for (int i = 0; i < products.size(); i++){
                     System.out.println(products.get(i));
                 }
                 System.out.print("Enter a product name to search, or type all to continue: ");
                 String searchName = scanner.next();

                 if (!searchName.equalsIgnoreCase("all")) {
                     for (int i = 0; i < products.size(); i++) {
                         if (products.get(i).getProductName().toLowerCase()
                                 .contains(searchName.toLowerCase())) {
                             System.out.println(products.get(i));
                         }
                     }
                 }
                 System.out.println("Enter a department to, or type all to continue: ");
                 String searchDepartment = scanner.next();

                 if (!searchDepartment.equalsIgnoreCase("all")){
                     for (int i = 0; i < products.size(); i++){

                     if (products.get(i).getDepartment().equalsIgnoreCase(searchDepartment)){
                         System.out.println(products.get(i));
                     }

                     }
                 }
                 System.out.println("Enter the SKU of the product you want to add: ");
                 String sku = scanner.next();

                     for (int i = 0; i < products.size(); i++) {
                         if (products.get(i).getSku().equalsIgnoreCase(sku)) {
                             shoppingCart.addToCart(products.get(i));
                             System.out.println("Product added to cart!");
                         }
                     }
                 break;
             case 2:
                 System.out.println("==== Your Cart ====");

                 for (int i = 0; i < shoppingCart.cart.size(); i++) {
                     System.out.println(shoppingCart.cart.get(i));
                 }
                 System.out.println("Cart Total: $" + shoppingCart.getCartTotal());


                 System.out.println("Enter the SKU of the product you want to remove:");
                 String removeSku = scanner.next();

                 for (int i = 0; i < shoppingCart.cart.size(); i++) {
                    if (shoppingCart.cart.get(i).getSku().equalsIgnoreCase(removeSku)) {
                        shoppingCart.removeFromCart(shoppingCart.cart.get(i));
                        System.out.println("product removed from cart!");
                        break;
                    }
                 }
                 break;

             case 3:
                 System.out.println("Thank you for shopping with us!");
                 return;
             default:
                 System.out.println("Invalid option. Please choose 1,2, or 3.");
         }
    }

    }

    public static void showMenu(){

    }

    //This method will find the product with the right sku
    //and return that product so later you can add it to the card
    public Product selectProductBySku(String sku){
        //for loops might help!
        return null;
    }

    public static void showAllProducts(){

    }

    public void searchProductsByName(String name){

    }

    public void searchProductsByPriceRange(double minPrice, double maxPrice){

    }

    public void searchProductsByCategory(String category){

    }
}