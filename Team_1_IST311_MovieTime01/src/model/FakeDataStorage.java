package model;

import model.Food.FoodType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Johnston <bjj5172@psu.edu>
 * creates a fake data storage
 * SBI-01
 */
public class FakeDataStorage implements IDataStorage
{
    private DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<Movie> _movies = new ArrayList<>();
    private List<Showing> _showings = new ArrayList<>();
    private List<Food> _foods = new ArrayList<>();

    public FakeDataStorage()
    {
        try
        {
            // movies added to the fake storage
            _movies.add(new Movie("This is Spinal Tap", _dateFormat.parse("1984-03-02")));
            _movies.add(new Movie("Airplane", _dateFormat.parse("1980-07-02")));
            _movies.add(new Movie("The Simpsons Movie", _dateFormat.parse("2007-07-27")));

            // showing added to the fake storage
            _showings.add(new Showing("8 PM",
                    new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                    createTheater3(),
                    12.00));
            _showings.add(new Showing("4 PM",
                    new Movie("This is Spinal Tap", _dateFormat.parse("1984-03-02")),
                    createTheater3(),
                    12.00));

            // adding SODA to the fakeDatabase
            _foods.add(new Food(FoodType.SODA, Food.FoodSize.S));
            _foods.add(new Food(FoodType.SODA, Food.FoodSize.M));
            _foods.add(new Food(FoodType.SODA, Food.FoodSize.L));

            // adding POPCORN to the fakeDatabase
            _foods.add(new Food(FoodType.POPCORN, Food.FoodSize.S));
            _foods.add(new Food(FoodType.POPCORN, Food.FoodSize.M));
            _foods.add(new Food(FoodType.POPCORN, Food.FoodSize.L));
        } catch (ParseException e)
        {
            System.out.println("Bad date format");
        }
    }

    //  creates theater #3
    private Theater createTheater3()
    {
        Theater theater = new Theater("#3");
        theater.addSeat(new Seat("A", 1));
        theater.addSeat(new Seat("B", 1));
        theater.addSeat(new Seat("C", 1));

        return theater;
    }

    // @author Mostafa Apu <mja5612@psu.edu>
    // main method to test the other method's output.
    public static void main(String[] args) throws ParseException
    {
        DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FakeDataStorage fakeDataStorage = new FakeDataStorage();
        // to repeatedly use it
        Showing showingName = new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00);
        // tests reserving a seat
        fakeDataStorage.reserveASeat(new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00), new Seat("A", 1));

        // prints out all the available seats
        List<Seat> results = fakeDataStorage.getAvailableSeats(showingName);
        System.out.println("Available seats:");
        for (Seat seat : results)
        {
            System.out.println(seat.getRowNumber());
        }

        System.out.println("-------------");

        System.out.println("-------------");

        // testing "getAllMovies" method
        List<Movie> results3 = fakeDataStorage.getAllMovies();
        System.out.println("All Movies:");
        for (Movie movie : results3)
        {
            SimpleDateFormat FMT_YEAR = new SimpleDateFormat("yyyy");
            String title = movie.getTitle();
            String year = FMT_YEAR.format(movie.getReleaseDate());

            System.out.printf("%s (%s)", title, year);
            System.out.println();
        }

        //@author Brian Johnston <bjj5172@psu.edu>
        //testing add showing and food to cart
        System.out.println("--------------");
        System.out.println("The items have been added to the cart");
        Cart cart = new Cart();
        List<Showing> showAdd = fakeDataStorage.getShowings(fakeDataStorage.returnMovie("Airplane"));
        for (Showing show : showAdd)
        {
            cart.add(show, 3);
        }
    }

    // @author Mostafa Apu <mja5612@psu.edu>
    // reserves a seat for a showing
    public void reserveASeat(Showing showing, Seat seat)
    {
        List<Seat> results = getAvailableSeats(showing);

        for (Showing newShowing : _showings)
        {
            if (newShowing.getShowTime().equals(showing.getShowTime())
                    && newShowing.getTheaterNumber().equals(showing.getTheaterNumber())
                    && newShowing.getTitle().equals(showing.getTitle()))
            {
                newShowing.getTheater().reserveASeat(seat);
                break;
            }
        }
    }

    // @author Mostafa Apu <mja5612@psu.edu>
    // returns a movie from a titleName
    public Movie returnMovie(String movieName)
    {
        Movie returnedMovie = null;
        for (Movie movie : _movies)
        {
            if (movie.getTitle().equals(movieName))
            {
                returnedMovie = movie;
            }
        }
        return returnedMovie;
    }

    // returns all the food
    public List<Food> getAllFood()
    {
        return _foods;
    }

    // returns a food
    public List<Food> getFood(FoodType foodType)
    {
        List<Food> foundFoods = new ArrayList<>();
        for (Food food : _foods)
        {
            if (food.returnFoodType().equals(foodType))
            {
                foundFoods.add(food);
            }
        }

        return foundFoods;
    }

    // @author Mostafa Apu <mja5612@psu.edu>
    // un-reserves a seat for a showing
    public void unReserveASeat(Showing showing, Seat seat)
    {
        List<Seat> results = getAvailableSeats(showing);

        for (Showing newShowing : _showings)
        {
            if (newShowing.getShowTime().equals(showing.getShowTime())
                    && newShowing.getTheaterNumber().equals(showing.getTheaterNumber())
                    && newShowing.getTitle().equals(showing.getTitle()))
            {
                newShowing.getTheater().unReserveASeat(seat);
                break;
            }
        }
    }

    //  creates theater #2
    private Theater createTheater2()
    {
        Theater theater = new Theater("#2");
        theater.addSeat(new Seat("D", 1));
        theater.addSeat(new Seat("E", 1));
        theater.addSeat(new Seat("F", 1));

        return theater;
    }

    @Override
    // filters a movie title with a substring
    public List<Movie> filterByTitle(String substringTitle)
    {
        List<Movie> foundMovies = new ArrayList<>();

        for (Movie movie : _movies)
        {
            if (movie.getTitle().toLowerCase().contains(substringTitle.toLowerCase()))
            {
                foundMovies.add(movie);
            }
        }

        return foundMovies;
    }

    @Override
    // returns all the movies
    public List<Movie> getAllMovies()
    {
        return _movies;
    }

    @Override
    // @author Mostafa Apu <mja5612@psu.edu>
    // @author Brian Johnston <bjj5172@psu.edu>
    // returns the showings for a movie
    public List<Showing> getShowings(Movie movie)
    {
        List<Showing> foundShowTimes = new ArrayList<>();
        for (Showing showing : _showings)
        {
            if (showing.getTitle().toLowerCase().contains(movie.getTitle().toLowerCase()))
            {
                foundShowTimes.add(showing);
            }
        }

        return foundShowTimes;
    }

    @Override
    // @author Mostafa Apu <mja5612@psu.edu>
    // returns the available seats for a showing
    public List<Seat> getAvailableSeats(Showing showing)
    {
        List<Seat> foundSeats = new ArrayList<>();
        for (Showing seat : _showings)
        {
            if (seat.getShowTime().equals(showing.getShowTime())
                    && seat.getTheaterNumber().equals(showing.getTheaterNumber())
                    && seat.getTitle().equals(showing.getTitle()))
            {
                foundSeats.addAll(seat.getTheater().getAvailableSeats());
                break;
            }
        }

        return foundSeats;
    }

    @Override
    // @author Mostafa Apu <mja5612@psu.edu>
    // returns all seats for a theater
    public List<Seat> getAllSeats(Theater theater)
    {
        List<Seat> foundSeats = new ArrayList<>();
        for (Showing seat : _showings)
        {
            if (seat.getTheaterNumber().equals(theater.getTheaterNumber()))
            {
                foundSeats.addAll(seat.getTheater().getAllSeats());
                break;
            }
        }

        return foundSeats;
    }
}
