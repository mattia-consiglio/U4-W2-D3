package functional_interfaces;

import Shop.Product;

@FunctionalInterface
public interface ProductModifier {
    public Product modify(Product t);
}
