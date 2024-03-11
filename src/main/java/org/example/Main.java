package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create an instance of the scanner class
        Scanner scanner = new Scanner(System.in);


        //create a shoppingCart object/Instance
        ShoppingCart cart = new ShoppingCart();

        //Display a menu to the user
        System.out.println("Welcome to CPL E-Commerce Order Processing App");
        System.out.println("Available products:");
        System.out.println("1. Product A - ksh1000");
        System.out.println("2. Product B - ksh1500");
        System.out.println("3. Product C - ksh2000");

        //Create a variable to save the user vhoice
        char userChoice;

        do {
            //Prompt the user to enter the product they want
            System.out.print("Enter product number to add to cart: ");
            int productNumber = scanner.nextInt();

            //Ask the user for the quantity of the product they have chosen
            System.out.print("Enter quantity: ");
            int productQuantity = scanner.nextInt();

            //Check which product the user chose to add to the cart
            switch (productNumber) {
                case 1:
                    cart.addItem(new Product("Product A", 1000.00,productQuantity));
                    break;
                case 2:
                    cart.addItem(new Product("Product B", 1500, productQuantity));
                    break;
                case 3:
                    cart.addItem(new Product("Product C", 2000, productQuantity));
                    break;
                default:
                    System.out.println("Invalid Product Number!");
            }
            //Ask the user if they wish to add another product
            System.out.println("Add another product to shopping cart? (y/n): ");
            userChoice = scanner.next().charAt(0);

        } while (userChoice == 'y');

        //Display the order summary
        System.out.println("Your Order Summary");

        //Display the order summary
        for (Product item : cart.items) {
            System.out.println(item.productName + " - Quantity: " + item.quantity + " - Price: ksh " + item.price);
        }

        //Display the cart total
        System.out.println("Total: ksh " + cart.calculateTotal());

        //Close the scanner object
        scanner.close();
    }
}