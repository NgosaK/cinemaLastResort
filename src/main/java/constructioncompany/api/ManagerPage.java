package constructioncompany.api;

import constructioncompany.domain.Manager;
import constructioncompany.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 2015/09/25.
 */
@RestController
@RequestMapping(value="/managers/**")
public class ManagerPage {

    @Autowired
    private EmployeeService service;

    //-------------------Retrieve All Managers--------------------------------------------------------

    @RequestMapping(value = "/managers", method=RequestMethod.GET)
    public ResponseEntity<List<Manager>> listAllManagers() {
        List<Manager> Managers = service.getEmployees();
        if(Managers.isEmpty()){
            return new ResponseEntity<List<Manager>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Manager>>(Managers, HttpStatus.OK);
    }


    //-------------------Retrieve Single Managers--------------------------------------------------------

    @RequestMapping(value = "/{id}/managers", method = RequestMethod.GET)
    public ResponseEntity<Manager> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching manager with id " + id);
        Manager Subject = service.getEmployee(id);
        if (Subject == null) {
            System.out.println("Manager with id " + id + " not found");
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Manager>(Subject, HttpStatus.OK);
    }



    //-------------------Create a Subject--------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> createSchedule(@RequestBody Manager manager){//,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Manager " + manager.getId());

        service.addEmployee(manager);

        // HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/manager/{id}").buildAndExpand(manager.getId()).toUri());
        return new ResponseEntity<Manager>(manager, HttpStatus.CREATED);
    }

    //------------------- Update a Subject --------------------------------------------------------

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<Manager> updateSubject(@PathVariable("id") long id, @RequestBody Manager manager) {
        System.out.println("Updating manager " + id);

        Manager currentManager = service.getEmployee(id);

        if (currentManager==null) {
            System.out.println("Manager with id " + id + " not found");
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }

        Manager updatedManager = new Manager
                .Builder(currentManager.getId())
                .copy(currentManager)
                .build();
        service.updateEmployee(updatedManager);
        return new ResponseEntity<Manager>(updatedManager, HttpStatus.OK);
    }

    //------------------- Delete a Subject --------------------------------------------------------

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Manager> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Manager with id " + id);

        Manager manager = service.getEmployee(id);
        if (manager == null) {
            System.out.println("Unable to delete. Manager with id " + id + " not found");
            return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
        }

        service.removeEmployee(manager);
        return new ResponseEntity<Manager>(HttpStatus.NO_CONTENT);
    }


}
