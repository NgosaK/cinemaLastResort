package constructioncompany.api;

import constructioncompany.domain.Beverage;
import constructioncompany.services.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
@RestController
@RequestMapping("/beverages/**")
public class BeveragePage {

    @Autowired
    private BeverageService service;

    //-------------------Retrieve All Consumables--------------------------------------------------------

    @RequestMapping(value = "/beverages", method= RequestMethod.GET)
    public ResponseEntity<List<Beverage>> listAllConsumables() {
        List<Beverage> consumablesList = service.getBeverages();
        if (consumablesList.isEmpty()) {
            return new ResponseEntity<List<Beverage>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Beverage>>(consumablesList, HttpStatus.OK);
    }

    //-------------------Retrieve Single beverages--------------------------------------------------------
    @RequestMapping(value = "/{id}/beverages/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Beverage> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching beverages with id: " + id);
        Beverage beverage = service.getBeverageByID(id);
        if (beverage == null) {
            System.out.println("Beverage with id " + id + " not found");
            return new ResponseEntity<Beverage>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Beverage>(beverage, HttpStatus.OK);
    }

    //-------------------Create a Consumable--------------------------------------------------------

    @RequestMapping(value = "/create", method= RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Beverage> createSubject(@RequestBody Beverage beverage,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating beverages " + beverage.getName());


        service.addBeverage(beverage);

        return new ResponseEntity<Beverage>(beverage, HttpStatus.CREATED);
    }

    //------------------- Update a Consumables --------------------------------------------------------

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<Beverage> updateSubject(@PathVariable("id") long id, @RequestBody Beverage beverages)
    {
        System.out.println("Updating Beverage " + id);

        Beverage currentConsumable = service.getBeverageByID(id);

        if (currentConsumable==null) {
            System.out.println("Beverage with id " + id + " not found");
            return new ResponseEntity<Beverage>(HttpStatus.NOT_FOUND);
        }

        Beverage updatedConsumable = new Beverage

                .Builder(currentConsumable.getCode())
                .copy((Beverage) currentConsumable)
                .build();
        service.updateBeverage(updatedConsumable);
        return new ResponseEntity<Beverage>(updatedConsumable, HttpStatus.OK);
    }

    //------------------- Delete a Consumable --------------------------------------------------------

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Beverage> deleteConsumable(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Consumable with id " + id);

        Beverage consumables = service.getBeverageByID(id);
        if (consumables == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Beverage>(HttpStatus.NOT_FOUND);
        }

        service.removeBeverage(consumables);
        return new ResponseEntity<Beverage>(HttpStatus.NO_CONTENT);
    }
}
