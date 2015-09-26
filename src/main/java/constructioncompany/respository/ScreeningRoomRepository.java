package constructioncompany.respository;

import constructioncompany.domain.ScreeningRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2015/09/24.
 */
@Repository
public interface ScreeningRoomRepository extends CrudRepository<ScreeningRoom,Long> {

}
