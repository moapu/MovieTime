package movieTime01;

import model.*;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Mostafa Apu <mja5612@psu.edu>
 */
public class TheaterHelperTest
{
    @Test
    // @author Mostafa Apu <mja5612@psu.edu>
    // SBI-10
    // As a developer, I want to test that a non-reserved seat can be reserved, so I know the code works
    public void test_reserveSeat_reserveANonReservedSeat_ReturnsAList() throws ParseException
    {
        // date
        DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // to hold a Seat
        Seat seatName = new Seat("C", 1);
        String[] expectedValues =
                {
                        "A1", "B1"
                };
        // to hold a Showing
        Showing showingName = new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00);
        String[] actualValues = new String[2];

        // reserves a seat
        TheaterHelper.reserveSeat(showingName, seatName);
        // prints out all the available seats
        List<Seat> results = TheaterHelper.getOpenSeats(showingName);
        for (int i = 0; i < results.size(); i++)
        {
            actualValues[i] = results.get(i).getRowNumber();
        }

        // test the values
        assertArrayEquals("--Should be A1, B1 --", expectedValues, actualValues);
    }

    @Test
    // @author Mostafa Apu <mja5612@psu.edu>
    // SBI-11
    // As a developer, I want to test that a reserved seat cannot be reserved again, so I know the code works
    public void test_reserveSeat_CannotReservedASeatAgain_ReturnsAList() throws ParseException
    {
        // date
        DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // to hold a Seat
        Seat seatName = new Seat("C", 1);
        String[] expectedValues =
                {
                        "A1", "B1"
                };

        // to hold a Showing
        Showing showingName = new Showing("8 PM",
                new Movie("Airplane", _dateFormat.parse("1980-07-02")),
                new Theater("#3"),
                12.00);
        String[] actualValues = new String[2];

        // reserves a seat
        TheaterHelper.reserveSeat(showingName, seatName);
        // prints out all the available seats
        List<Seat> results = TheaterHelper.getOpenSeats(showingName);
        for (int i = 0; i < results.size(); i++)
        {
            actualValues[i] = results.get(i).getRowNumber();
        }

        // tries to reserve the same seat again
        TheaterHelper.reserveSeat(showingName, seatName);

        // test the values
        assertArrayEquals("--Should be A1, B1 --", expectedValues, actualValues);
    }

}
