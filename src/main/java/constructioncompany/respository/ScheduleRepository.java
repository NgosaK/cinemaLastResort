package constructioncompany.respository;

import constructioncompany.domain.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2015/09/24.
 */
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Long> {

}

