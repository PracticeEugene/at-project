package src.ui.main.commom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ShopItems {

    SAUCE_LABS_BACKPACK("Sauce Labs Backpack", "29.99"),
    SAUCE_LABS_BIKE_LIGHT("Sauce Labs Bike Light", "9.99"),
    SAUCE_LABS_BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt", "15.99");

    private final String name;
    private final String price;

    public static List<ShopItems> getItems() {
        return List.of(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT);
    }

    public static List<String> getItemNames(List<ShopItems> items) {
        return items.stream()
                .map(ShopItems::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getItemNames(ShopItems... items) {
        return Stream.of(items)
                .map(ShopItems::getName)
                .collect(Collectors.toList());
    }
}
