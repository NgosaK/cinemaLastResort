package constructioncompany.services;

import constructioncompany.domain.Beverage;

import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
public interface BeverageService {


    List<Beverage> getBeverages();

    Beverage getBeverageByID(long id);
    Beverage addBeverage(Beverage beverage);
    void removeBeverage(Beverage beverage);
    Beverage updateBeverage(Beverage beverage);

}