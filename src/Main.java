import Shop.Customer;
import Shop.Order;
import Shop.Product;
import functional_interfaces.ProductModifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Dune", "Books");
        Product p2 = new Product("Apple", "Food");
        Product p3 = new Product("Banana", "Boys");
        Product p4 = new Product("Pineapple", "BaBy");
        Product p5 = new Product("Done 2", "Books");

        List<Product> products = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5));

        Customer c1 = new Customer("Mattia", 3);
        Customer c2 = new Customer("Mario", 2);
        Customer c3 = new Customer("Luigi", 2);
        Customer c4 = new Customer("Pippo", 4);
        Customer c5 = new Customer("Paperino", 5);

        List<Customer> customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4, c5));

        Order o1 = new Order("created", LocalDate.parse("2021-02-01"), LocalDate.parse("2021-02-05"), c1);
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p3);
        Order o2 = new Order("created", LocalDate.parse("2021-02-05"), LocalDate.parse("2021-02-10"), c2);
        o2.addProduct(p4);
        o2.addProduct(p5);
        Order o3 = new Order("created", LocalDate.parse("2021-02-10"), LocalDate.parse("2021-02-15"), c3);
        o3.addProduct(p3);
        o3.addProduct(p4);
        o3.addProduct(p5);
        Order o4 = new Order("created", LocalDate.parse("2023-02-15"), LocalDate.parse("2023-02-20"), c4);
        o4.addProduct(p1);
        o4.addProduct(p2);
        o4.addProduct(p3);
        Order o5 = new Order("created", LocalDate.parse("2024-02-20"), LocalDate.parse("2024-02-25"), c5);
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p3);
        o5.addProduct(p4);

        List<Order> orders = new ArrayList<Order>(Arrays.asList(o1, o2, o3, o4, o5));


        // 1. Obtain a list af products that are in the category "Books" and have a price greater than 100.
        List<Product> products1 = products.stream().filter(product -> product.getCategory().equalsIgnoreCase("books") && product.getPrice() > 100).toList();
        System.out.println("1. Obtain a list af products that are in the category \"Books\" and have a price greater than 100");
        System.out.println();
        products1.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");


        // 2. Obtain a list of orders that have a product with the category "Baby".
        List<Order> orders1 = orders.stream().filter(order -> order.getProducts().stream()
                .anyMatch(product -> product.getCategory().equalsIgnoreCase("baby"))).toList();

        System.out.println("2. Obtain a list of orders that have a product with the category \"Baby\"");
        System.out.println();
        orders1.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");


        ProductModifier productModifier = product -> {
            double price = product.getPrice();
            product.setPrice(price - (price * 0.1));
            return product;
        };

        // 3. Obtain a list of products that have category "boys" and apply 10% discount to their original price.
        List<Product> products2 = products.stream().filter(product -> product.getCategory().equalsIgnoreCase("boys")).map(productModifier::modify).toList();


        System.out.println("3. Obtain a list of products that have category \"boys\" and apply 10% discount to their original price");
        System.out.println();
        products2.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");


        // 4. Obtain a list of products that have a customer with tier 2 and that have been ordered between 1st February and 1st April.
        List<Product> products3 = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) && order.getOrderDate().isBefore(LocalDate.parse("2021-04-01")))
                .map(order -> order.getProducts()).flatMap(p -> p.stream()).toList();

        System.out.println("4. Obtain a list of products that have a customer with tier 2 and that have been ordered between 1st February and 1st April");
        System.out.println();
        products3.forEach(System.out::println);

    }
}