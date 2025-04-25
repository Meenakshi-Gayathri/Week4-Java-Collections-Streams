package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return productId + " | Revenue: $" + totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}

public class ProductSalesAnalysis {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String productId = in.nextLine();
            int quantity = in.nextInt();
            double price = in.nextDouble();
            in.nextLine();
            sales.add(new Sale(productId, quantity, price));
        }

        // 1. Filter: quantity > 10
        List<Sale> filtered = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(Collectors.toList());

        // 2. Transform to ProductSales (productId, totalRevenue)
        List<ProductSales> transformed = filtered.stream()
                .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
                .collect(Collectors.toList());

        // 3. Sort by total revenue descending
        List<ProductSales> sorted = transformed.stream()
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .collect(Collectors.toList());

        // 4. Top 5 products
        List<ProductSales> top5 = sorted.stream()
                .limit(5)
                .collect(Collectors.toList());

        top5.forEach(System.out::println);
    }
}

