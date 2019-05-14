package movieTime01;

import model.Movie;
import model.MovieHelper;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author bjj5172
 */
public class MovieHelperTest
{
    @Test
    //@author Brian Johnston <bjj5172@psu.edu>
    //SBI-012
    public void test_searchTitle_SearchMoviesContainingThe_ReturnsAList()
    {
        String[] expectedValue = {"The Simpsons Movie"};
        String[] actualValue = new String[1];

        //To Search for a movie
        List<Movie> results = MovieHelper.searchTitle("The");

        for (int i = 0; i < results.size(); i++)
        {
            actualValue[i] = results.get(i).getTitle();
        }

        //Testing Values
        assertArrayEquals("--Should have returned The Simpsons Movie--", expectedValue, actualValue);
    }

    @Test
    //@author Brian Johnston <bjj5172@psu.edu>
    //SBI-013
    public void test_searchTitle_SearchMoviesContainingRandomCharacters_ReturnsAList()
    {
        String[] expectedValue = {null};
        String[] actualValue = new String[1];

        //Search for a movie that doesn't exist
        List<Movie> results = MovieHelper.searchTitle("asdfasdf");

        for (int i = 0; i < results.size(); i++)
        {
            actualValue[i] = results.get(i).getTitle();
        }

        //Testing Values
        assertArrayEquals("--This movie doesn't exist. Please search for a movie that's being shown--", expectedValue, actualValue);
    }
}


    

