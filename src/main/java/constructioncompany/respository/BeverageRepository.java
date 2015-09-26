package constructioncompany.respository;

/**
 * Created by User on 2015/09/24.
 */

import constructioncompany.domain.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository extends CrudRepository<Beverage,Long>
{


}
