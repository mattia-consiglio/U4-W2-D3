package functional_interfaces;

@FunctionalInterface
public interface GeneralModifier<T> {
    public T modify(T t);
}
