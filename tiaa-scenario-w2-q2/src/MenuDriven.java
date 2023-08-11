import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Price: " + price;
    }
}

public class MenuDriven {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Edit Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        products.add(new Product(name, price));
        System.out.println("Product added successfully.");
    }

    private static void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void editProduct() {
        System.out.print("Enter product name to edit: ");
        String productName = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.print("Enter new product name: ");
                String newName = scanner.nextLine();

                System.out.print("Enter new product price: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();

                products.set(i, new Product(newName, newPrice));
                System.out.println("Product edited successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    private static void removeProduct() {
        System.out.print("Enter product name to remove: ");
        String productName = scanner.nextLine();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                System.out.println("Product removed successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }
}