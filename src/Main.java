import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> productsList = new ArrayList<>();
        Product cheese = new Product(250, "Сыр", "Продукты");
        Product wheels = new Product(50000, "Шины", "Автомото");
        Product copybook = new Product(60, "Тетрадь", "Канцелярия");
        Product laptop = new Product(150000, "Ноутбук", "Компьютеры");
        Product toothpaste = new Product(350, "Зубная паста", "Товары для дома");
        Product tomatos = new Product(120, "Помидоры", "Продукты");
        Product airfreshnerer = new Product(400, "Освежитель", "Товары для дома");
        Product paper = new Product(900, "Бумага", "Канцелярия");
        Product keyboard = new Product(2500, "Клавиатура", "Компьютеры");
        Product breakPads = new Product(7000, "Тормозные колодки", "Автомото");

        productsList.add(cheese);
        productsList.add(wheels);
        productsList.add(copybook);
        productsList.add(laptop);
        productsList.add(toothpaste);
        productsList.add(tomatos);
        productsList.add(airfreshnerer);
        productsList.add(paper);
        productsList.add(keyboard);
        productsList.add(breakPads);

        System.out.println("\nОтсортированный по цене список всех продуктов:\n");
        Printer.printList(Shop.sortProductsByPrice(productsList));
        System.out.println("Самый дорогой продукт:\n");
        Product maxPriceProduct = Shop.getMostExpensiveProduct(productsList);
        System.out.println(maxPriceProduct.name + "..." + maxPriceProduct.price);

        // проверка правильного количества продуктов
        assertThat(productsList.size()).isEqualTo(10);

        // проверка верного содержимого корзины
        assertThat(cheese).isIn(productsList);
        assertThat(wheels).isIn(productsList);
        assertThat(copybook).isIn(productsList);
        assertThat(laptop).isIn(productsList);
        assertThat(toothpaste).isIn(productsList);
        assertThat(tomatos).isIn(productsList);
        assertThat(airfreshnerer).isIn(productsList);
        assertThat(paper).isIn(productsList);
        assertThat(keyboard).isIn(productsList);
        assertThat(breakPads).isIn(productsList);

        // проверка корректности работы метода getMostExpensiveProduct
        for (Product next : productsList) {
            assertThat(Shop.getMostExpensiveProduct(productsList).price).isGreaterThanOrEqualTo(next.price);
        }

        // проверка корректности работы метода sortProductsByPrice
        for (int i = 1; i < productsList.size(); i++) {
            assertThat(productsList.get(i).price).isGreaterThanOrEqualTo(productsList.get(i-1).price);
        }
    }
}