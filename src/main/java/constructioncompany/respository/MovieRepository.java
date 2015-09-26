package constructioncompany.respository;

import constructioncompany.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2015/09/24.
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {
}
