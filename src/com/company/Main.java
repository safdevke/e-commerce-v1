package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        System.out.println(" ------ e-commerce System ------ ");
        try {
            do {
                System.out.println("Choose an option below");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                input = scanner.nextInt();
                Controller controller = new Controller();
                switch (input) {
                    case 1:
                        controller.registerUser(newUser());
                        break;
                    case 2:
                        if (!controller.loginUser(existingUser())) {
                            System.out.println("Incorrect username or password!");
                        }else {
                            cartMenu();
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                }
            } while (input != 3);
        } catch (Exception e) {
            System.out.println("Invalid Input");
            System.out.println();
            menu( );
        }
    }


    public static UserProfile newUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String name = scanner.nextLine();
        System.out.println( );
        System.out.println("Enter password");
        String passwd = scanner.nextLine( );
        System.out.println("Enter email");
        String email = scanner.nextLine( );
        System.out.println( );
        UserProfile user = new UserProfile( );
        user.setName(name);
        user.setPassword(passwd);
        user.setEmail(email);
        return user;
    }


    public static UserProfile existingUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String name = scanner.nextLine( );
        System.out.println( );
        System.out.println("Enter password");
        String passwd = scanner.nextLine( );
        UserProfile user = new UserProfile( );
        user.setName(name);
        user.setPassword(passwd);
        return user;
    }

    public static void cartMenu() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        System.out.println(" ------ welcome to your cart ------ ");
        try {
            do {
                System.out.println("Choose an option below");
                System.out.println("1. Add items to cart");
                System.out.println("2. Show items in cart");
                System.out.println("3. Exit");
                input = scanner.nextInt();
                Controller controller = new Controller( );
                switch (input) {
                    case 1:
                        controller.addToCart(newItems());
                        break;
                    case 2:
                        for (Cart cart : controller.showCart( )) {
                            System.out.println(cart);
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Input");
                        System.out.println( );
                }
            } while (input != 3);
        } catch (Exception e) {
            System.out.println("Invalid Input");
            System.out.println( );
            cartMenu( );
        }
    }

    public static Cart newItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name");
        String name = scanner.nextLine( );
        System.out.println( );
        System.out.println("Enter product price");
        float price = scanner.nextFloat();
        scanner.nextLine();
        Cart cart = new Cart();
        cart.setProductName(name);
        cart.setProductPrice(price);
        return cart;
    }
}



