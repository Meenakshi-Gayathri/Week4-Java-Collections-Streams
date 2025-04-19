package collections;

import java.util.*;

public class ShoppingCart {

    HashMap<String, Double> productPriceMap = new HashMap<>();
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    TreeMap<Double, List<String>> priceSortedMap = new TreeMap<>();

    public void addProduct(String productName, double price) {
        productPriceMap.put(productName, price);
        priceSortedMap.putIfAbsent(price, new ArrayList<>());
        priceSortedMap.get(price).add(productName);
    }

    public void addToCart(String productName, int quantity) {
        if (!productPriceMap.containsKey(productName)) {
            System.out.println("Product not found: " + productName);
            return;
        }
        cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
    }

    public void displayCart() {
        System.out.println("Cart items in the order added:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productPriceMap.get(product);
            System.out.println(product + " " + qty + " " + price + " each");
        }
    }

    public void displaySortedByPrice() {
        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, List<String>> entry : priceSortedMap.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                System.out.println(product + " - " + price);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cartSystem = new ShoppingCart();

        cartSystem.addProduct("Pen", 10.0);
        cartSystem.addProduct("Notebook", 50.0);
        cartSystem.addProduct("Pencil", 5.0);
        cartSystem.addProduct("Eraser", 5.0);
        cartSystem.addProduct("Bag", 500.0);

        cartSystem.addToCart("Pencil", 2);
        cartSystem.addToCart("Notebook", 1);
        cartSystem.addToCart("Pen", 3);
        cartSystem.addToCart("Eraser", 1);
        cartSystem.addToCart("Bag", 1);

        System.out.println("\nCart Summary");
        cartSystem.displayCart();

        System.out.println("\nProducts Sorted by Price");
        cartSystem.displaySortedByPrice();
    }
}
