package constructioncompany.services;

import constructioncompany.domain.Manager;

import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
public interface EmployeeService {

    List<Manager> getEmployees();

    Manager getEmployee(long id);
    Manager addEmployee(Manager employee);
    void removeEmployee(Manager employee);
    Manager updateEmployee(Manager employee);
}