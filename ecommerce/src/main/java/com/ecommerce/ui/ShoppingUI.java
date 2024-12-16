package com.ecommerce.ui;

import com.ecommerce.utils.Validation;
import com.ecommerce.utils.Reports;
import com.ecommerce.models.ShoppingCart;
import com.ecommerce.models.Order;
import com.ecommerce.models.Product;
import com.ecommerce.models.Customer;
import com.ecommerce.controller.ProductsRegistry;

import java.util.Scanner;

public class ShoppingUI {
    private ShoppingUI() {
    }

    public static void menu(Customer customer, Scanner scanner)
        throws Exception {

        boolean exit = false;
        ShoppingCart shoppingCart = null;

        while (!exit) {
            ClearTerminal.clear();

            System.out.println("[0] Exit" +
                               "\n[1] Add product" +
                               "\n[2] View shopping cart" +
                               "\n[3] Finish order" +
                               "\n\nChoose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0": {
                    System.out.println("\n\nReturning...");
                    exit = true;
                    break;
                }

                case "1": {
                    shoppingCart = addProductMenu(shoppingCart, customer, scanner);
                    Reports.compareAndChangePurchase(shoppingCart);
                    break;
                }

                case "2": {
                    if (shoppingCart != null) {
                        shoppingCart.display();
                        System.out.println("==============================================" +
                                        "\nPress enter to go back.");
                        scanner.nextLine();
                    } else {
                        ClearTerminal.clear();
                        System.out.println("\nYour shopping cart is empty." +
                                           "\nPress enter to go back.");
                        scanner.nextLine();
                    }
                    break;
                }

                case "3": {
                    if (shoppingCart != null) {
                        customer.addPurchase(shoppingCart);
                        Order order = shoppingCart.getOrder();
                        order.decrementStock();
                        Reports.compareAndChangePurchase (shoppingCart);
                    } else {
                        ClearTerminal.clear();
                        System.out.println("\nYour shopping cart is empty." +
                                           "\nPress enter to go back.");
                        scanner.nextLine();
                        break;
                    }
                    ClearTerminal.clear();
                    System.out.println("\nOperation was successful!" +
                                       "\n\nPress enter to continue...");
                    scanner.nextLine();
                    exit = true;
                    break;
                }

                default:
            }
        }
    }

//     this could be way better if divided into different methods.
    private static ShoppingCart addProductMenu(ShoppingCart shoppingCartMenu, Customer customer, Scanner scanner) {

        int productId = -1;
        int quantity = 0;
        String input = "";
        Order order = new Order();
        ShoppingCart shoppingCart = shoppingCartMenu;
        int previousQuantity = 0;

        while (true) {
            ClearTerminal.clear();

            System.out.println("==============================================");
            System.out.println("PRODUCTS");
            System.out.println("==============================================");

            ProductsRegistry.displayProducts();
            System.out.println("==============================================");
            System.out.println("\nType 'exit' to leave or 'save' to save changes.");

            System.out.print("\nInsert the product ID to add to your cart: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("save") && !order.isEmpty()) {
                if (shoppingCart == null) {
                    shoppingCart = saveCart(customer, order);  // Salva o carrinho se ele ainda for null
                }
                return shoppingCart;  // Retorna o carrinho com o pedido
            } else if(input.equalsIgnoreCase("save") && order.isEmpty()) {
                break;  // Interrompe o loop se o pedido estiver vazio
            }

            try {
                productId = Integer.parseInt(input);
                if (!ProductsRegistry.containsKey(productId)) {
                    System.out.println("\nProduct ID not found. Press enter to try again.");
                    scanner.nextLine();
                    continue;
                }

                Product product = ProductsRegistry.get(productId);

                System.out.print("\nQuantity: ");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else if (input.equalsIgnoreCase("save") && !order.isEmpty()) {
                    if (shoppingCart == null) {
                        shoppingCart = saveCart(customer, order);  // Salva o carrinho se for null
                    }
                    return shoppingCart;
                } else if(input.equalsIgnoreCase("save") && order.isEmpty()) {
                    break;
                }

                quantity = Integer.parseInt(input);
                if (quantity <= 0) {
                    System.out.println("\nQuantity can't be negative or equals zero. Press enter to try again.");
                    scanner.nextLine();
                    continue;
                }

                order.addProduct(product, quantity);

                if (shoppingCart != null) {
                    previousQuantity = shoppingCart.getQuantityByProduct(product);
                }

                if (!product.isStockEnough((order.getQuantity(product) + previousQuantity))) {

                    System.out.println("\nNot enough products in Stock. Press enter to try again.");
                    scanner.nextLine();
                    order.decrementQuantity(product, quantity);
                    continue;
                }

                else if(shoppingCart == null) {
                    shoppingCart = saveCart(customer, order);  // Salva o carrinho
                } else {
                    shoppingCart.updateOrder(order, product, quantity);  // Atualiza o carrinho
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return shoppingCart;  // Retorna o carrinho final após o loop
}

    private static ShoppingCart saveCart(Customer customer, Order order) {
        if (order != null) {
            return new ShoppingCart(customer, order);
        }
        return null;
    }
}
