import java.util.List;

public interface VendingMachine {

    public Product getProduct();
    public Product getProduct(String name);
    public Product getProduct(String name, int price);

    public void putProduct(Product product);

    public void putProductsList(List<Product> manyProduct);

}
