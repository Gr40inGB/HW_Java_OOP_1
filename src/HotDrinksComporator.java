import java.util.Comparator;

public class HotDrinksComporator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
//        return Integer.compare(((HotDrinks)o1).getTemperature(),((HotDrinks)o2).getTemperature());
        return ((HotDrinks) o1).compareTo((HotDrinks)o2);
    }
}
