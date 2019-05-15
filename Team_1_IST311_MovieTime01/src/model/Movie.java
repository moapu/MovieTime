package model;

import java.util.Date;

/**
 * Movie will be used to represent a single movie
 */
public class Movie {

    // Title of the movie
    private String _title;

    // The wide-release date
    private Date _releaseDate;

    /**
     * Movie constructor
     *
     * @param title       the title of the movie
     * @param releaseDate the wide-release date
     */
    public Movie(String title, Date releaseDate) {
        this._title = title;
        this._releaseDate = releaseDate;
    }

    /**
     * Get the title of the movie
     *
     * @return the title of the Movie
     */
    public String getTitle() {
        return _title;
    }

    /**
     * Set the title of the movie
     *
     * @param title the title of the Movie
     */
    public void setTitle(String title) {
        this._title = title;
    }

    /**
     * Get the release date
     *
     * @return the release date
     */
    public Date getReleaseDate() {
        return _releaseDate;
    }

    /**
     * Set the release date
     *
     * @param releaseDate the release date of the movie
     */
    public void setReleaseDate(Date releaseDate) {
        this._releaseDate = releaseDate;
    }

}
