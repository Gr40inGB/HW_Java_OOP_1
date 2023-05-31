import java.util.ArrayList;
import java.util.List;

public class VendingMachineWater implements VendingMachine {

    static private int waterVendingMachineCount;

    private List<Product> productsStock;
    private int number;

    public VendingMachineWater() {

        this.number = ++waterVendingMachineCount;
        this.productsStock = new ArrayList<>();
    }

    public Product getProduct() {
        if (productsStock.size() > 0) {
            return productsStock.remove(productsStock.size() - 1);
        } else {
            System.out.println("Sorry :( We don't have any product for you");
            return null;
        }
    }

    public List<Product> getProductsStock() {
        return productsStock;
    }

    public void showStock() {
        for (Product pr : productsStock) {
            System.out.println(pr);
        }
    }

    public int getProductsStockSize() {
        return productsStock.size();
    }

    public Product getProduct(String name, int price) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                if (currentProduct.getName().equals(name) && currentProduct.getPrice() == price) {
                    return currentProduct;
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    public Product getProduct(String name) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                if (currentProduct.getName().equals(name)) {
                    return productsStock.remove(productsStock.size() - 1);
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    @Override
    public void putProduct(Product product) {
        productsStock.add(product);
    }

    @Override
    public void putProductsList(List<Product> putList) {
        productsStock.addAll(putList);
    }
}
