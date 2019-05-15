package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * A helper class related to tasks of a movie
 * It will hold methods that technically are categories as the "view" aspect of a movie
 * That will help us keep the view separate from the model
 */
public class MovieHelper {

    private static SimpleDateFormat FMT_YEAR = new SimpleDateFormat("yyyy");
    private static FakeDataStorage _dataStorage = new FakeDataStorage();
    private static DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // to test the methods
    public static void main(String[] args) {
        // returns a list of movies containing the passed in substring
        List<Movie> movies = MovieHelper.searchTitle("air");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }

        System.out.println("--------------------");

        // returns a list of all movies
        List<Movie> allMovies = MovieHelper.getAll();
        for (Movie movie : allMovies) {
            System.out.println(movie.getTitle());
        }

        System.out.println("--------------------");

        try {
            // returns a list of all movies
            List<Showing> showTimes = MovieHelper.getShowings(new Movie("airplane", _dateFormat.parse("1980-07-02")));
            for (Showing showing : showTimes) {
                System.out.printf(showing.getShowTime() + " |" +
                        showing.getTitle() + " |" +
                        showing.getTheater() + " |" +
                        "$" + showing.getPrice());
            }
        } catch (Exception exception) {
            System.out.println("BAd format");
        }
    }

    // SBI-02
    // returns the movies with the passed in substring
    public static List<Movie> searchTitle(String substring) {
        return _dataStorage.filterByTitle(substring);
    }

    // returns all the movies
    public static List<Movie> getAll() {
        return _dataStorage.getAllMovies();
    }

    public static List<Showing> getShowings(Movie movie) {
        return _dataStorage.getShowings(movie);
    }

    /**
     * Return a string having the movie title, followed by the year it was released in parentheses
     * e.g., "Airplane (1980)"
     *
     * @param movie
     * @return the movie title and release year
     */
    public String titleAndReleaseYear(Movie movie) {
        String title = movie.getTitle();
        String year = FMT_YEAR.format(movie.getReleaseDate());
        return String.format("%s (%s)", title, year);
    }

}