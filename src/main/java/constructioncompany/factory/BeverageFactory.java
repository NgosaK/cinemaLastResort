package constructioncompany.factory;

import constructioncompany.domain.Beverage;

import java.util.Map;

/**
 * Created by User on 2015/09/24.
 */
public class BeverageFactory {

    public static Beverage createBeverage(
            Map<String,String> values, long code) {
        Beverage beverage = new Beverage
                .Builder(code)
                .name(values.get("name"))
                .category(values.get("category"))
                .price(values.get("price"))
                .volume(values.get("volume"))
                .build();

        return beverage;

    }
}
