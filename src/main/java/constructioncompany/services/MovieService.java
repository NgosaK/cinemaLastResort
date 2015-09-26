package constructioncompany.services;

import constructioncompany.domain.Movie;

import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
public interface MovieService  {


    List<Movie> getMovie();

    Movie getMovieByID(long id);
    Movie addMovie(Movie movie);
    void removeMovie(Movie movie);
    Movie updateMovie(Movie movie);
}

