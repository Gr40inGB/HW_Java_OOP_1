import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        VendingMachineWater vendingMachineWater = new VendingMachineWater();
//        Water waterBonAqua = new Water("Bon Aqua", 2);
//        Water waterRedKey = new Water("Red Key", 3);
//        Water justWater = new Water("Just Water", 1);
//        List<Product> listForPut = new ArrayList<>();
//        listForPut.add(waterRedKey);
//        listForPut.add(waterRedKey);
//        listForPut.add(waterRedKey);
//        listForPut.add(justWater);
//        listForPut.add(justWater);
//        listForPut.add(justWater);
//        listForPut.add(justWater);
//        vendingMachineWater.putProductsList(listForPut);
//        vendingMachineWater.putProduct(waterBonAqua);
//        vendingMachineWater.putProduct(waterBonAqua);
//        vendingMachineWater.putProduct(waterBonAqua);
//        vendingMachineWater.showStock();
//
//        System.out.println(vendingMachineWater.getProduct());
//        System.out.println(vendingMachineWater.getProductsStockSize());
//        System.out.println(vendingMachineWater.getProduct("Bon Aqua"));
//        System.out.println(vendingMachineWater.getProduct("Bon Aqua", 3));
//        System.out.println(vendingMachineWater.getProduct("Bon Aqua", 2));
//        System.out.println(vendingMachineWater.getProduct("Bon Aqua", 2));
//        System.out.println(vendingMachineWater.getProductsStockSize());
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