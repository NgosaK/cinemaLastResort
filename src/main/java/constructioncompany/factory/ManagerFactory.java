package constructioncompany.factory;

import constructioncompany.domain.Manager;

import java.util.Map;

/**
 * Created by User on 2015/09/24.
 */
public class ManagerFactory {

    public static Manager createManager(
            Map<String,String> values, long code) {
        Manager manager = new Manager
                .Builder(code)
                .phoneNumber(values.get("phoneNumber"))
                .name(values.get("name"))
                .numberOfEmployees(values.get("numOfEmployees"))
                .jobTitle(values.get("jobTitle"))
                .department(values.get("department"))
                .build();

        return manager;

    }
}
