import Shop.Customer;
import Shop.Order;
import Shop.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Dune", "Books", 15.0);
        Product p2 = new Product("Apple", "Food", 1.0);
        Product p3 = new Product("Banana", "Boys", 1.5);
        Product p4 = new Product("Pineapple", "Baby", 1.2);
        Product p5 = new Product("Done 2", "Books", 1.6);

        Customer c1 = new Customer("Mattia", 3);
        Customer c2 = new Customer("Mario", 2);
        Customer c3 = new Customer("Luigi", 1);
        Customer c4 = new Customer("Pippo", 4);
        Customer c5 = new Customer("Paperino", 5);

        Order o1 = new Order("created", LocalDate.parse("2021-Feb-01"), LocalDate.parse("2021-Feb-05"), c1);
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p3);
        Order o2 = new Order("created", LocalDate.parse("2021-Feb-05"), LocalDate.parse("2021-Feb-010"), c2);
        o2.addProduct(p4);
        o2.addProduct(p5);
        Order o3 = new Order("created", LocalDate.parse("2021-Feb-10"), LocalDate.parse("2021-Feb-15"), c3);
        o3.addProduct(p3);
        o3.addProduct(p4);
        o3.addProduct(p5);
        Order o4 = new Order("created", LocalDate.parse("2021-Feb-15"), LocalDate.parse("2021-Feb-20"), c4);
        o4.addProduct(p1);
        o4.addProduct(p2);
        o4.addProduct(p3);
        Order o5 = new Order("created", LocalDate.parse("2021-Feb-20"), LocalDate.parse("2021-Feb-25"), c5);
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p3);
        o5.addProduct(p4);


    }
}