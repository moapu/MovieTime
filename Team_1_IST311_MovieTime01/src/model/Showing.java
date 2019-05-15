package model;

public class Showing {

    private String _showTime;
    private String _title;
    private Theater _theater;
    private double _price;

    public Showing(String showTime, Movie movie, Theater theater, double price) {
        this._showTime = showTime;
        this._title = movie.getTitle();
        this._theater = theater;
        this._price = price;
    }

    // @returns Title of the movie
    public String getTitle() {
        return _title;
    }

    // @param Title the movie title
    public void setTitle(String title) {
        this._title = title;
    }

    // @returns showtime of the movie
    public String getShowTime() {
        return _showTime;
    }

    // @param showTime the movie showtime
    public void setShowTime(String showTime) {
        this._showTime = showTime;
    }

    // @returns Theater Number
    public String getTheaterNumber() {
        return _theater.getTheaterNumber();
    }

    // @returns Theater
    public Theater getTheater() {
        return _theater;
    }

    // @param Theater the theater number
    public void setTheater(Theater theater) {
        this._theater = theater;
    }

    // @returns Price
    public double getPrice() {
        return _price;
    }

    // @param the price of movie
    public void setPrice(double price) {
        this._price = price;
    }

}


