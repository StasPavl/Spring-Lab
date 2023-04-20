package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Movie findByName(String name);


    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(Integer priceStarts,Integer priceEnds);


    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDuration(List<Integer> durations);


    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate dateTime);


    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(State state, Type type);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> retrieveAllMoviesWithPriceRange(Integer priceStart, Integer priceEnd);


    //Write a JPQL query that returns all movie names
    @Query("select m.name from Movie m")
    List<Movie> retrieveAllMovieNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select * from movie where name = ?1",nativeQuery = true)
    Movie fetchMovieByName(String name);


    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> retrieveMoviesInPriceRange(Integer priceStart, Integer priceEnd);


    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from movie where duration in ?1", nativeQuery = true)
    List<Movie> retrieveAllMovieInDurationRange(List<Integer> durations);


    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select * from movie Order By price desc limit 5", nativeQuery = true)
    List<Movie> retrieveTop5ExpensiveMovie();


}
