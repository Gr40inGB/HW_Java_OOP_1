[VendingMachine.java](src%2FVendingMachine.java)

```java
import java.util.List;

public interface VendingMachine {
    public Product getProduct();
    public Product getProduct(String name);
    public Product getProduct(String name, int price);
    
    public void putProduct(Product product);
    public void putProductsList(List<Product> manyProduct);
}
```
[HotDrinkVendingMashine.java](src%2FHotDrinkVendingMashine.java)
```java
import java.util.ArrayList;
import java.util.List;

public class HotDrinkVendingMashine implements VendingMachine {

    static private int HotDrinkVendingMachineCount;

    private List<Product> productsStock;
    private int number;

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

    public List<Product> getProductsStock() {
        return productsStock;
    }

    public int getNumber() {
        return number;
    }

    public Product getProduct(String name, int price, int temperature) {
        if (productsStock.size() > 0) {
            for (int i = 0; i < productsStock.size(); i++) {
                Product currentProduct = productsStock.get(i);
                HotDrinks hd = (HotDrinks) currentProduct;
                if (currentProduct.getName().equals(name) &&
                        currentProduct.getPrice() == price &&
                        hd.getTemperature() == temperature) {
                    System.out.println(currentProduct instanceof HotDrinks);
                    return currentProduct;
                }
            }
            System.out.println("Sorry :( We don't have that product for you");
            return null;
        }
        System.out.println("Sorry :( We don't have any product for you");
        return null;
    }

    public void showStock() {
        for (Product pr : productsStock) {
            System.out.println((HotDrinks)pr);
        }
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
```
[HotDrinks.java](src%2FHotDrinks.java)
```java
public class HotDrinks extends Water {
    private int temperature;

    public HotDrinks(String name, int price) {
        super(name, price);
    }

    public HotDrinks(String name, int price, int temperature) {
        super(name, price);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ((HotDrinks) this).getTemperature() + "\u00B0";
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

```
Main
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotDrinkVendingMashine hotDrinkVM = new HotDrinkVendingMashine();
        HotDrinks coffeeLatte = new HotDrinks("Coffee Latte", 5, 50);
        HotDrinks coffeeBlack = new HotDrinks("Coffee Black", 4, 55);
        HotDrinks tea = new HotDrinks("Tea Green", 3, 55);
        HotDrinks teaB = new HotDrinks("Tea Black", 3, 55);

        List<Product> lsHotDrinks = new ArrayList<>();
        lsHotDrinks.add(coffeeBlack);
        lsHotDrinks.add(tea);
        lsHotDrinks.add(tea);
        lsHotDrinks.add(tea);
        lsHotDrinks.add(teaB);

        hotDrinkVM.putProductsList(lsHotDrinks);

        hotDrinkVM.putProduct(coffeeLatte);

        System.out.println(hotDrinkVM.getNumber());

        hotDrinkVM.showStock();
        System.out.println(hotDrinkVM.getProduct());
        System.out.println(coffeeBlack);

        System.out.println("-----------------------");

        System.out.println(hotDrinkVM.getProduct("Tea Green"));
        System.out.println(hotDrinkVM.getProduct("Tea Green",3));
        System.out.println(hotDrinkVM.getProduct("Tea Green",3,100));
        System.out.println(hotDrinkVM.getProduct("Tea Green",3,55));

    }
}
```
