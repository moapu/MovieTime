package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TheaterHelper {

    private static FakeDataStorage _dataStorage = new FakeDataStorage();

    // SBI-05
    // un-reserves a seat for a showing
    public static void unReserveSeat(Showing showing, Seat seat) {
        _dataStorage.unReserveASeat(showing, seat);
    }

    // tests the methods
    public static void main(String[] args) throws ParseException {
        DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // to repeatedly use it
        Showing showingName = new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00);
        Seat seatName = new Seat("C", 1);

        // to repeatedly use it
        Showing showingName2 = new Showing("4 PM",
                new Movie("This is Spinal Tap", _dateFormat.parse("1984-03-02")),
                new Theater("#2"),
                12.00);
        Seat seatName2 = new Seat("D", 1);


        // tests reserving a seat
        TheaterHelper.reserveSeat(showingName, seatName);

        // prints out all the available seats
        List<Seat> results = TheaterHelper.getOpenSeats(showingName);
        System.out.println("Available seats:");
        for (Seat seat : results) {
            System.out.println(seat.getRowNumber());
        }

        // returns all the seats
        List<Seat> results2 = TheaterHelper.getAll(
                new Theater("#3"));
        System.out.println("\nAll seats:");
        for (Seat seat : results2) {
            System.out.println(seat.getRowNumber());
        }
    }

    // SBI-04
    // reserves a seat for a showing
    public static void reserveSeat(Showing showing, Seat seat) {
        _dataStorage.reserveASeat(showing, seat);
    }

    // SBI-03
    // gets all the available seats
    public static List<Seat> getOpenSeats(Showing showing) {
        return _dataStorage.getAvailableSeats(showing);
    }

    // gets all the seats of a theater
    public static List<Seat> getAll(Theater theater) {
        return _dataStorage.getAllSeats(theater);
    }

}
