package model;

public class Seat {

    private String row;
    private int number;
    private String rowNumber;
    private boolean isReserved = false;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
        this.rowNumber = row + number;
    }

    //return the row number
    public String getRowNumber() {
        return rowNumber;
    }

    //return the row
    // e.g., "A"
    public String getRow() {
        return row;
    }

    //set the row
    public void setRow(String row) {
        this.row = row;
    }

    //number in the row
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // reserves a sit for the customer
    public void reserveSeat() {
        isReserved = true;
    }

    // un-reserves a sit for the customer
    public void unReserveSeat() {
        isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }

}

