import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Shop {
    public static List<Product> sortProductsByPrice (List<Product> productList) {
        productList.sort(Comparator.comparing(Product::getPrice));
        return productList;
    }

    public static Product getMostExpensiveProduct(List<Product> productList) {
        Product productMax = productList.get(0);

        for (Product next : productList) {
            if (next.price > productMax.price) {
                productMax = next;
            }
        }
        return productMax;
    }
}
