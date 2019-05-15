package model;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    // theater number
    // e.g, "#3"
    private String _theaterNum;

    // seats in the theater
    private List<Seat> _seats;

    public Theater(String _theaterNum) {
        this._theaterNum = _theaterNum;
        _seats = new ArrayList<>();
    }

    public void set_theaterNum(String _theaterNum) {
        this._theaterNum = _theaterNum;
    }

    public String getTheaterNumber() {
        return _theaterNum;
    }

    // adds a seat to the theater list
    public void addSeat(Seat seat) {
        _seats.add(seat);
    }

    // returns all the seats in the list
    public List<Seat> getAllSeats() {
        return _seats;
    }

    // returns the available seats
    // if its not reserved
    public List<Seat> getAvailableSeats() {
        List<Seat> foundSeats = new ArrayList<>();
        for (Seat seat : _seats) {
            if (seat.isReserved() == false) {
                foundSeats.add(seat);
            }
        }
        return foundSeats;
    }

    // reserves a seat
    public void reserveASeat(Seat newSeat) {
        for (Seat seat : _seats) {
            if (seat.getRowNumber().equals(newSeat.getRowNumber()) && seat.isReserved() == false) {
                seat.reserveSeat();
                break;
            } else if (seat.getRowNumber().equals(newSeat.getRowNumber()) && seat.isReserved() == true) {
                System.out.println("Seat already reserved!");
                break;
            }
        }
    }

    // un-reserves a seat
    public void unReserveASeat(Seat newSeat) {
        for (Seat seat : _seats) {
            if (seat.getRowNumber().equals(newSeat.getRowNumber()) && seat.isReserved() == true) {
                seat.unReserveSeat();
                break;
            }
        }
    }

}
