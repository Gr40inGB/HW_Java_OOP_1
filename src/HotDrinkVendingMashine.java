import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HotDrinkVendingMashine implements VendingMachine, Iterable<Product> {

    static private int HotDrinkVendingMachineCount;

    private List<Product> productsStock;
    private int number;
    private int counter;

    public HotDrinkVendingMashine() {
        this.number = ++HotDrinkVendingMachineCount;
        this.productsStock = new ArrayList<>();
    }

    @Override
    public Product getProduct() {
        if (productsStock.size() > 0) {
            return productsStock.remove(productsStock.size() - 1);
        } else {
            System.out.println("Sorry :( We don't have any product for you");
            return null;
        }
    }

    @Override
    public Product getProduct(String name) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                if (currentProduct.getName().equals(name)) {
                    return productsStock.remove(i);
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    @Override
    public Product getProduct(String name, int price) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                if (currentProduct.getName().equals(name) && currentProduct.getPrice() == price) {
                    return productsStock.remove(i);
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    public Product getProduct(String name, int price, int temperature) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                if (currentProduct.getName().equals(name) &&
                        currentProduct.getPrice() == price &&
                        ((HotDrinks) currentProduct).getTemperature() == temperature) {
                    return productsStock.remove(i);
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    public List<Product> getProductsStock() {
        return productsStock;
    }

    public int getNumber() {
        return number;
    }

    public void showStock() {
        System.out.println("Stock of №" + this.number + " hot drink vending machine:");
        for (Product pr : productsStock) {
            System.out.println("\t" + (HotDrinks) pr);
        }
    }

    public void sortByTemperature() {
        Collections.sort(productsStock, new HotDrinksComporator());
    }


    public void sortByPrice() {
        Collections.sort(productsStock, new ProductComporatorByPrice());
    }


    @Override
    public void putProduct(Product product) {
        productsStock.add(product);
    }

    @Override
    public void putProductsList(List<Product> putList) {
        productsStock.addAll(putList);
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductVMachineIterator(productsStock);
    }

}
