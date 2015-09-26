package constructioncompany.api;

import constructioncompany.domain.Beverage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Creator on 9/19/2015.
 */
@RestController
@RequestMapping("/")
public class LandingPage {
    @RequestMapping(method = RequestMethod.GET)
    public Beverage getSite(){
        Beverage beverage = new Beverage.Builder(8).name("till").category("Coke").price("12").volume("500").build();
        return beverage;
    }

}
