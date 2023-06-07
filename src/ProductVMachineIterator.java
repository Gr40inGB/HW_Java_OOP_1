import java.util.Iterator;
import java.util.List;

public class ProductVMachineIterator implements Iterator<Product> {

    private List<Product> productList;
    private int index;

    public ProductVMachineIterator(List<Product> ProductList) {
        this.productList = ProductList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return productList.size() > index;
    }

    @Override
    public Product next() {
        return productList.get(index++);
    }
}
