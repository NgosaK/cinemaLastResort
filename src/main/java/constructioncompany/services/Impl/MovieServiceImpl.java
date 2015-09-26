package constructioncompany.services.Impl;

import constructioncompany.domain.Movie;
import constructioncompany.respository.MovieRepository;
import constructioncompany.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> getMovie() {
        List<Movie> allMovies = new ArrayList<>();
        Iterable<Movie> movies = repository.findAll();
        for (Movie movie : movies) {
            allMovies.add(movie);
        }
        return allMovies;
    }

    @Override
    public Movie getMovieByID(long id) {
        return repository.findOne(id);    }

    @Override
    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public void removeMovie(Movie movie) {
        repository.delete(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return repository.save(movie);
    }
}
