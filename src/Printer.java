import java.util.Iterator;
import java.util.List;

public class Printer {
    public static void printList(List<Product> list) {
        Iterator<Product> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            Product nextProduct = listIterator.next();
            System.out.println(nextProduct.name + "..." + nextProduct.price + "руб.\n");
        }
    }
}
