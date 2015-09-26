package constructioncompany.factory;

import constructioncompany.domain.Movie;

import java.util.Map;

/**
 * Created by User on 2015/09/24.
 */
public class MovieFactory {

    public static Movie createMovie(
            Map<String,String> values, long code) {
        Movie movie = new Movie
                .Builder(code)
                .price(values.get("price"))
                .type(values.get("type"))
                .genre(values.get("genre"))
                .duration(values.get("duration"))
                .title(values.get("title"))
                .build();

        return movie;
    }
}
