package model;

import java.util.List;

/**
 * @author mja5612
 */
public class DataStorage implements IDataStorage
{
    @Override
    public List<Movie> filterByTitle(String title)
    {
        return null;
    }

    @Override
    public List<Movie> getAllMovies()
    {
        return null;
    }

    @Override
    public List<Showing> getShowings(Movie movie)
    {
        return null;
    }

    @Override
    public List<Seat> getAvailableSeats(Showing showing)
    {
        return null;
    }

    @Override
    public List<Seat> getAllSeats(Theater theater)
    {
        return null;
    }
}
