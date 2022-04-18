package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.service;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Movie;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.hibernate.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public Integer createMovie(Movie movie) {
        return saveMovie(movie).getId();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(Integer id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isEmpty()) {
            throw new PropertyNotFoundException("Movie not found");
        }

        return optionalMovie.get();
    }

    public Movie removeMovieById(Integer id) {
        Movie movie = findMovieById(id);

        movieRepository.deleteById(id);

        return movie;
    }
}
