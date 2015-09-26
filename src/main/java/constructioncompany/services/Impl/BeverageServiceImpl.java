package constructioncompany.services.Impl;

import constructioncompany.domain.Beverage;
import constructioncompany.respository.BeverageRepository;
import constructioncompany.services.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
@Service
public class BeverageServiceImpl implements BeverageService {

    @Autowired
    private BeverageRepository repository;

    @Override
    public List<Beverage> getBeverages() {
        List<Beverage> allBeverages = new ArrayList<>();
        Iterable<Beverage> beverages = repository.findAll();
        for (Beverage beverage : beverages) {
            allBeverages.add(beverage);
        }
        return allBeverages;
    }

    @Override
    public Beverage getBeverageByID(long id) {
        return repository.findOne(id);    }

    @Override
    public Beverage addBeverage(Beverage beverage) {

        return repository.save(beverage);
    }


    @Override
    public void removeBeverage(Beverage beverage) {
        repository.delete(beverage);

    }

    @Override
    public Beverage updateBeverage(Beverage beverage) {
        return repository.save(beverage);    }
}


