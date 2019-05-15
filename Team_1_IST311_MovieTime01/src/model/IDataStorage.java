package model;

import java.util.List;

/**
 * all the interface methods
 */

public interface IDataStorage {

    List<Movie> filterByTitle(String title);

    List<Movie> getAllMovies();

    List<Showing> getShowings(Movie movie);

    List<Seat> getAvailableSeats(Showing showing);

    List<Seat> getAllSeats(Theater theater);

}
